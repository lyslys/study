package com.utils.excel;

import com.common.Allenum.AccountConstant;
import com.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    /**
     *
     * 通用导出
     *
     * liangyansheng
     *
     * @param data  数据源
     * @param response
     * @param titleName  大标题名称  如 车辆超速汇总
     * @param sheetName  sheet名称
     * @param headers   标题列 如 {序号，车牌号，车辆所属点部}
     * @throws Exception
     */
    public static void exportExcel(List data, HttpServletResponse response, String titleName, String sheetName, String[] headers) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        String fileName = titleName + "-" + sdf.format(new Date()) + ".xls";
        int rowNum = 4;

        //ssheet分页数
        int number = 1;

        //设置标题和制表时间
        setTitle(workbook,sheet,titleName,headers);

        //序号数字
        int num = 1;

        //在表中存放查询到的数据放入对应的列
        if (data != null) {

            //临时字符串
            String tempStr = "";

            String [] columnHeaders =  CommonUtils.columnHeaders;

            //列表样式
            HSSFCellStyle cellStyle = setListStyle(workbook);

            //右边列表样式
            HSSFCellStyle rightCellStyle = setRight(workbook);

            //下边列表样式
            HSSFCellStyle bottomCellStyle = setBottom(workbook);

            //右和下边列表样式
            HSSFCellStyle bottomAndRightCellStyle = bottomAndRightCellStyle(workbook);

            int size = data.size()+3;

            //记录最大的列宽
            Map<Integer,Integer> mapMax = new HashMap<Integer,Integer>();

            for (Object obj : data) {

                if(rowNum==5004){

                    sheet = workbook.createSheet(sheetName+"("+number+")");

                    setTitle(workbook,sheet,titleName,headers);

                    rowNum=4;

                    number++;

                    size-=5000;
                }

                HSSFRow hssfRow = sheet.createRow(rowNum);

                boolean isStyle = rowNum == size || rowNum == 4999;

                Map<String,Object> map =  getClassValue(obj);

                for(int i=0;i<columnHeaders.length;i++) {

                    HSSFCell cell  =  hssfRow.createCell(i);

                    tempStr = columnHeaders[i];

                    cell.setCellStyle(cellStyle);

                    if ("序号".equals(tempStr)) {
                        cell.setCellValue(num);
                        cell.setCellStyle(isStyle?bottomCellStyle:cellStyle);
                        continue;
                    }

                    Object objectValue = null;

                    if(map.get(tempStr) == null && !tempStr.contains(".")){
                        continue;
                    }

                    //    String str = map.get(tempStr).toString();

                    //数据里面有包含对象的时候，
                    if(tempStr.contains("/")){  //解析 "vehicleSpecification.emissionStandard_排放标准"

                        String [] paramArray = tempStr.split("/");

                        objectValue = analyzePoint(map,paramArray[0])+"/"+analyzePoint(map,paramArray[1]);

                    }else if(tempStr.contains(".")){  //  解析 "vehicleFinance.monthDepreciationRate/vehicleFinance.totalDepreciationAmount_月折旧率/累计折旧额"

                        objectValue = analyzePoint(map,tempStr);

                    }else{
                        //通过字符取出对应的值
                        objectValue = map.get(tempStr);
                    }

                    //通过字符取出对应的值
                    //        Object objectValue = map.get(tempStr);

                    if(objectValue == null){
                        continue;
                    }

                    //获取对应的值字符串长度 ，而且去掉前后的空格
                    int maxnei = objectValue.toString().trim().getBytes().length*460;

                    if(mapMax.get(i)==null){
                        mapMax.put(i,headers[i].getBytes().length*460);
                    }

                    if(maxnei>mapMax.get(i)){
                        mapMax.put(i,maxnei);
                    }

                    if(mapMax.get(i)>20000){
                        mapMax.put(i,20000);
                    }

                    sheet.setColumnWidth(i,mapMax.get(i));

                    //设置样式
                    if(columnHeaders.length-1 == i){
                        cell.setCellStyle(isStyle?bottomAndRightCellStyle:rightCellStyle);
                    }else{
                        cell.setCellStyle(isStyle?bottomCellStyle:cellStyle);
                    }

                    if( CommonUtils.dataMap.get(tempStr) != null){//转换数据字典

                        cell.setCellValue(AccountConstant.MonthAccountStatusEnum.getEnum(((Integer)objectValue).byteValue()).getText());

                    }else{

                        if(objectValue instanceof Date){
                            cell.setCellValue(DateUtils.dateToStr((Date)objectValue));
                        }else{
                            cell.setCellValue(objectValue.toString());
                        }

                    }

                }

                rowNum++;

                num++;

            }
            System.out.println(mapMax);
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }


    /**
     *
     * 把obj这个类的字段名和字段的值 放进map key 字段名  value 字段的值
     *
     * @param obj 需要反射的类
     * @return
     * @throws Exception
     */
    public static Map<String,Object>  getClassValue(Object obj) throws  Exception{

        Map<String,Object> map = new HashMap<String,Object>();

        if(obj instanceof Map){
            map.putAll((Map)obj);
            return map;
        }

        Class clazz = obj.getClass();
//        System.out.println("类的名称是：" + clazz.getName());
        /**
         * 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields获取的是该类自己声明的成员变量的信息
         */
        Field[] fs = clazz.getDeclaredFields();
        for (Field field : fs) {
            // 得到成员变量的类型的类类型
            Class filedType = field.getType();
            String typeName = filedType.getName();
            String fieldName = field.getName();
//            System.out.println(typeName + " " + fieldName);

            //设置是否允许访问，不是修改原来的访问权限修饰词。
            field.setAccessible(true);
            //返回输出指定对象a上此 Field表示的字段名和字段值
//            System.out.println(field.getName()+":"+field.get(obj));
            map.put(field.getName(),field.get(obj));
        }
        return map;
    }

    /**
     * 统一设置表头
     * @param workbook
     * @param sheet
     * @param titleName  标题名称
     * @param totalColumn  总列数
     */
    public static void setTitle(HSSFWorkbook workbook,HSSFSheet sheet,String titleName,String[] headers){

        int totalColumn = headers.length-1;

        // excel生成过程: excel-->sheet-->row-->cell

        HSSFRow row = sheet.createRow(1); // 创建一行,参数2表示第一行
        row.setHeightInPoints(25);//设置行的高度
        HSSFCell cell = row.createCell(0); // 创建一个单元格
        cell.setCellValue(titleName); // B2单元格填充内容

        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 单元格样式
        Font fontStyle = workbook.createFont(); // 字体样式
        fontStyle.setBold(true); // 加粗
        fontStyle.setFontName("微软雅黑"); // 字体
        fontStyle.setFontHeightInPoints((short) 14); // 大小
        // 将字体样式添加到单元格样式中
        cellStyle.setFont(fontStyle);

        // 合并单元格
        CellRangeAddress cra =new CellRangeAddress(1, 1, 0, totalColumn); // 起始行, 终止行, 起始列, 终止列
        sheet.addMergedRegion(cra);

        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setTopBorderColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //拿到palette颜色板
        HSSFPalette palette = workbook.getCustomPalette();
        //这个是重点，具体的就是把之前的颜色 HSSFColor.LIME.index
        //替换为  RGB(51,204,204) 宝石蓝这种颜色
        //你可以改为 RGB(0,255,127)
        palette.setColorAtIndex(IndexedColors.ORANGE.getIndex(), (byte) 112, (byte) 48, (byte) 160);

        cell.setCellStyle(cellStyle);

        for(int i=1;i<totalColumn;i++){
            row.createCell(i).setCellStyle(cellStyle);
        }

        //设置最后一列
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setRightBorderColor(IndexedColors.ORANGE.getIndex());
        row.createCell(totalColumn).setCellStyle(cellStyle);

        //制表时间
        HSSFRow rowTime = sheet.createRow(2); // 创建一行,参数2表示第一行
        rowTime.setHeightInPoints(24);//设置行的高度
        HSSFCell cellTime = rowTime.createCell(0); // 创建一个单元格
        cellTime.setCellValue("制表时间："); // 单元格填充内容

        sheet.setColumnWidth(0,"制表时间：".getBytes().length*260);

        HSSFCell cellTime2 =  rowTime.createCell(1);

        cellTime2.setCellValue(DateUtils.dateToStrTwo(new Date()));

        // 合并单元格
        CellRangeAddress craTime =new CellRangeAddress(2, 2, 1, totalColumn); // 起始行, 终止行, 起始列, 终止列
        sheet.addMergedRegion(craTime);

        HSSFCellStyle cellStyleTime = workbook.createCellStyle(); // 单元格样式

        cellStyleTime.setBorderTop(BorderStyle.THIN);

        //每列设置样式
        for(int i=2;i<totalColumn;i++){
            rowTime.createCell(i).setCellStyle(cellStyleTime);
        }

        Font fontStyleTime = workbook.createFont(); // 字体样式
        fontStyleTime.setBold(true); // 加粗
        fontStyleTime.setFontName("微软雅黑"); // 字体
        fontStyleTime.setFontHeightInPoints((short) 11); // 大小
        // 将字体样式添加到单元格样式中
        cellStyleTime.setFont(fontStyleTime);

        cellStyleTime.setBorderRight(BorderStyle.THIN);
        cellStyleTime.setAlignment(HorizontalAlignment.CENTER);
        cellStyleTime.setVerticalAlignment(VerticalAlignment.CENTER);
        cellTime.setCellStyle(cellStyleTime);

        HSSFCellStyle cellStyleTime2 = workbook.createCellStyle(); // 单元格样式

        cellStyleTime2.setBorderTop(BorderStyle.THIN);
        cellStyleTime2.setFont(fontStyleTime);
        cellStyleTime2.setAlignment(HorizontalAlignment.LEFT);
        cellStyleTime2.setVerticalAlignment(VerticalAlignment.CENTER);
        cellTime2.setCellStyle(cellStyleTime2);

        //设置最后一列
        HSSFCellStyle cellStyleTime3 = workbook.createCellStyle(); // 单元格样式
        cellStyleTime3.setBorderTop(BorderStyle.THIN);
        cellStyleTime3.setBorderRight(BorderStyle.MEDIUM);
        cellStyleTime3.setRightBorderColor(IndexedColors.ORANGE.getIndex());
        rowTime.createCell(totalColumn).setCellStyle(cellStyleTime3);

        //--------------------设置表头
/*        String[] headers = {"车牌号", "使用点部","点部负责人", "所属大区", "车辆业务类型", "车辆属性","行驶计提里程(km)","行车时长",
                "车牌号", "使用点部","点部负责人", "所属大区", "车辆业务类型", "车辆属性","行驶计提里程(km)","行车时长",
                "车牌号", "使用点部","点部负责人", "所属大区","所属大区"};*/

        HSSFRow rowThree= sheet.createRow(3);
        rowThree.setHeightInPoints(20);//设置行的高度

        Font fontStyleTime6 = workbook.createFont(); // 字体样式
        fontStyleTime6.setFontName("微软雅黑"); // 字体
        fontStyleTime6.setFontHeightInPoints((short) 11); // 大小

        HSSFCellStyle cellStyleTime6 = workbook.createCellStyle(); // 单元格样式
        cellStyleTime6.setBorderBottom(BorderStyle.THIN);
        cellStyleTime6.setBorderRight(BorderStyle.THIN);
        cellStyleTime6.setBorderTop(BorderStyle.THIN);
        cellStyleTime6.setAlignment(HorizontalAlignment.CENTER);
        cellStyleTime6.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleTime6.setFont(fontStyleTime6);

        //拿到palette颜色板
        HSSFPalette palette2 = workbook.getCustomPalette();
        //这个是重点，具体的就是把之前的颜色 HSSFColor.LIME.index
        //替换为  RGB(51,204,204) 宝石蓝这种颜色
        //你可以改为 RGB(0,255,127)
        palette2.setColorAtIndex(IndexedColors.GREY_25_PERCENT.index, (byte) 217, (byte) 217, (byte) 217);

        cellStyleTime6.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);// 设置背景色
        cellStyleTime6.setFillPattern(cellStyleTime6.getFillPatternEnum().SOLID_FOREGROUND);

        for (int i = 0; i < totalColumn; i++) {
            HSSFCell cell6 = rowThree.createCell(i);
            cell6.setCellStyle(cellStyleTime6);
            cell6.setCellValue(headers[i]);
        }

        //设置最后一列
        HSSFCellStyle cellStyleTimeLast6 = workbook.createCellStyle(); // 单元格样式
        cellStyleTimeLast6.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);// 设置背景色
        cellStyleTimeLast6.setFillPattern(cellStyleTime6.getFillPatternEnum().SOLID_FOREGROUND);
        cellStyleTimeLast6.setBorderBottom(BorderStyle.THIN);
        cellStyleTimeLast6.setBorderTop(BorderStyle.THIN);
        cellStyleTimeLast6.setBorderRight(BorderStyle.MEDIUM);
        cellStyleTimeLast6.setRightBorderColor(IndexedColors.ORANGE.getIndex());
        cellStyleTimeLast6.setAlignment(HorizontalAlignment.CENTER);
        cellStyleTimeLast6.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleTimeLast6.setFont(fontStyleTime6);

        HSSFCell cell6 = rowThree.createCell(totalColumn);
        cell6.setCellValue(headers[totalColumn]);
        cell6.setCellStyle(cellStyleTimeLast6);

        for (int i = 0; i < headers.length; i++) {
            sheet.setColumnWidth(i,headers[i].getBytes().length*460);
        }

    }

    /**
     * 设置列表的样式
     * @param workbook
     * @param cell
     */
    public static HSSFCellStyle setListStyle(HSSFWorkbook workbook){

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        Font fontStyle = workbook.createFont(); // 字体样式
        fontStyle.setFontName("微软雅黑"); // 字体
        fontStyle.setFontHeightInPoints((short) 11); // 大小
        // 将字体样式添加到单元格样式中
        cellStyle.setFont(fontStyle);

        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return  cellStyle;
    }

    /**
     * 设置右边样式
     */
    public static HSSFCellStyle setRight(HSSFWorkbook workbook){
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setRightBorderColor(IndexedColors.ORANGE.getIndex());

        Font fontStyle = workbook.createFont(); // 字体样式
        fontStyle.setFontName("微软雅黑"); // 字体
        fontStyle.setFontHeightInPoints((short) 11); // 大小
        // 将字体样式添加到单元格样式中
        cellStyle.setFont(fontStyle);

        return cellStyle;
    }

    /**
     * 设置下边样式
     */
    public static HSSFCellStyle setBottom(HSSFWorkbook workbook){
        HSSFCellStyle cellStyle = setListStyle(workbook);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBottomBorderColor(IndexedColors.ORANGE.getIndex());
        return cellStyle;
    }

    /**
     * 设置右和下边样式
     */
    public static HSSFCellStyle bottomAndRightCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle cellStyle = setListStyle(workbook);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBottomBorderColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setRightBorderColor(IndexedColors.ORANGE.getIndex());

        Font fontStyle = workbook.createFont(); // 字体样式
        fontStyle.setFontName("微软雅黑"); // 字体
        fontStyle.setFontHeightInPoints((short) 11); // 大小
        // 将字体样式添加到单元格样式中
        cellStyle.setFont(fontStyle);

        return cellStyle;
    }

    /**
     * 解析点 "vehicleSpecification.emissionStandard_排放标准"
     *
     * @return
     */
    public static Object analyzePoint(Map<String,Object> map,String tempStr) throws Exception{
        Object objectValue = null;
        String [] paramArray =  tempStr.split("\\.");
        if(map.get(paramArray[0]) != null ){
            Map<String,Object> newMap =  getClassValue(map.get(paramArray[0]));
            objectValue = newMap.get(paramArray[1]);
        }
        return  objectValue;
    }

}
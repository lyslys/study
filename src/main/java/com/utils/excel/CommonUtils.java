package com.utils.excel;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils{

    //存放初始化数据
    public  static Map<String,Object> dataMap = new HashMap<String,Object>();

    //要转换成数据字典的字段 key 字段名 value 业务名
    public  static Map<String,String> changeMap = new HashMap<String,String>();

    //字段名数组
    public  static String [] columnHeaders;

    //标题名称数组
    public  static String [] headers;

    public static void  init(List<Map> list, String name){

        Map<String,String> mapNew = new HashMap<String,String>();
        for(Map map :  list){
            mapNew.put(map.get("regionCode").toString(),map.get("deptName").toString());
        }
        dataMap.put(name,mapNew);

    }

    /**
     * 获取数字字典的值
     * @param codeNum  序号代码
     * @param name  业务key  存放表里面的 如  vms_region
     * @return
     */
    public static String  get(Object codeNum,String name){

        if(codeNum == null || StringUtils.isBlank(name)){
            return  "";
        }

        return  dataMap.get(name) != null?((Map<String,String>)dataMap.get(name)).get(codeNum.toString()):"";
    }

    /**
     * 动态组成字段名  动态表头才需要解析
     */
    public static void  partField(String [] headersNew){

        if(headersNew == null){
            return ;
        }

        String [] tempStr;

        columnHeaders = new String[headersNew.length];
        headers = new String[headersNew.length];

        for(int i=0;i<headersNew.length;i++){
            tempStr =  headersNew[i].split("_");
            columnHeaders[i] = tempStr[0];
            headers[i] = tempStr[1];
        }

    }

    private static DecimalFormat getDecimalFormat(int scale){
        StringBuilder sb = new StringBuilder("#0.");
        for(int i=0; i<scale; i++) {
            sb.append("0");
        }
        return new DecimalFormat(sb.toString());
    }

    public static String formatPercent(double percent) {
        if (percent == 0) {
            return "0%";
        }
        BigDecimal decimal = new BigDecimal(percent);
        int scale = 2;
        percent = decimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        while (percent == 0) {
            scale += 2;
            percent = decimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        DecimalFormat df = getDecimalFormat(scale);
        return df.format(percent) + "%";
    }

}
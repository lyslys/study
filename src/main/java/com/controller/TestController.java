package com.controller;

import com.mapper.test.StudentMapper;
import com.model.User;
import com.model.test.Student;
import com.utils.excel.CommonUtils;
import com.utils.excel.ExcelUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TestController{

    @Autowired
    private Resource resource;

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/springboot")
    public String Hello() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/getRes")
    public Resource getRes() {
        Resource resourceNew = new Resource();
        BeanUtils.copyProperties(resource,resourceNew);
        return resourceNew;
    }

    @RequestMapping("/getR")
    public String getR() {
        return "66";
    }

    @RequestMapping("/excel")
    public void excel(HttpServletResponse response,String[] headers) {

        try {

            //初始化数字字典
          /*  String[] businessCode = {"vms_region","vms_business_type","vms_vehicle_attribute_type"};
            lookupValueService.initDigitalDictionary(businessCode);

            //数据字典要转换的字段
            CommonUtils.changeMap.put("region","vms_region");
            CommonUtils.changeMap.put("businessType","vms_business_type");
            CommonUtils.changeMap.put("vehicleAttribute","vms_vehicle_attribute_type");*/


            Map mapZD = new HashMap();
            mapZD.put(0, "六二六二六");
            mapZD.put(1, "阿斯顿法国");
            mapZD.put(3, "六二没有填六二六");
            CommonUtils.dataMap.put("accountStatus", mapZD);

            //设置字段 ，通过反射取得字段的值
          /*  String[] columnHeaders = {"序号","plateNumber","driverName","region","useNetwork","managementLeader",
                                        "businessType","vehicleAttribute","simNumber","warnSpeed","aveSpeed","startTime","endTime","time","startAddress","endAddress"};*/

            //导出的url  http://127.0.0.1:13038/rptVehicleOverspeedDetail/exportExcelSummaryDetail?startTime=2018-07-01&endTime=2018-07-25&headers=序号_序号,plateNumber_车牌号,startAddress_车辆超速开始位置,endAddress_车辆超速结束位置

            //http://127.0.0.1:8080/excel?headers=序号_序号,age_年龄,name_姓名,sex_性别

            //http://127.0.0.1:8888/excel?headers=序号_序号,age_年龄,name_姓名,sex_性别,accountStatus_状态

            //   String[] headers = {"序号_序号","plateNumber_车牌号","startAddress_车辆超速开始位置","endAddress_车辆超速结束位置"};

            //动态表头才需要解析 序号_序号,plateNumber_车牌号,driverName_司机姓名,region_车辆所属大区
            CommonUtils.partField(headers);

            List<User> userList = new ArrayList<User>();
            User user = new User();
            user.password = "123456";
            user.setAge("16");
            user.setName("张三");
            user.setSex("男");
            userList.add(user);
            User user1 = new User();
            user1.setAge("17");
            user1.setName("张是");
            user1.setSex("女");
            userList.add(user1);

            List<HashMap<String, Object>> mapList = new ArrayList<>();
            HashMap<String, Object> map = new HashMap<>();
            map.put("age", 66);
            map.put("name", "小红");
            map.put("sex", "女");
            map.put("accountStatus", 0);

            mapList.add(map);
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("age", 77);
            map1.put("name", "小名");
            map1.put("sex", "男");
            map1.put("accountStatus", 1);

            mapList.add(map1);


            ExcelUtils.exportExcel(mapList,response,"用户信息","用户信息",CommonUtils.headers);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/stu/{id}")
    public Student getStu(@PathVariable("id") Integer id){
        return  studentMapper.getStudentById(id);
    }
    
}
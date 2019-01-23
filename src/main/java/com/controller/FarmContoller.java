package com.controller;

import com.result.CodeMsg;
import com.result.Result;
import com.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;


@Controller
@RequestMapping(value = "/farm")
public class FarmContoller extends BaseController {

 /*   @Autowired
    private FarmService farmService;*/

    /**
     * 返回业务员列表页面
     *
     * @author lys
     */
    @RequestMapping("/farmList")
    public String farmList() {
        return "manage/farm/farmList";
    }

    @RequestMapping("/farmMain")
    public String farmMain() {
        return "manage/farm/farmMain";
    }

    /**
     * 列表查询
     *
     * @author lys
     * @date 2016年6月30日 下午6:06:28
     */
    @ResponseBody
    @RequestMapping("/queryList")
    public ModelMap queryList(ModelMap mm, HttpServletRequest rq, final String name, final String departmentId) {
        return mm;
    }

    /**
     * 跳转到form
     *
     * @author lys
     */
    @RequestMapping("/toForm")
    public String toForm(ModelMap mm, Integer id) {
        return "manage/farm/farmForm";
    }

/*    @RequestMapping("/saveFarm")
    public int saveFarm(String name, Long minute, BigDecimal price, String storeName) {
        return farmService.saveFarm(name, minute, price, storeName);
    }*/

}
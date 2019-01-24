package com.controller;

import com.model.LdUser;
import com.result.CodeMsg;
import com.result.Result;
import com.service.LdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/sample")
public class SampleContoller extends BaseController {

    @Autowired
    private LdUserService ldUserService;

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("helloJUC");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<LdUser> dbGet() {
        LdUser ldUser = ldUserService.getById(1);
        return Result.success(ldUser);
    }



}
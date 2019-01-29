package com.controller.lightningdeal;

import com.controller.BaseController;
import com.model.dto.LoginDto;
import com.model.result.CodeMsg;
import com.model.result.Result;
import com.service.LdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "/login")
public class LoginContoller extends BaseController {

    @Autowired
    private LdUserService ldUserService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "lightningdeal/login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginDto loginDto) {
        //登录
        return Result.success(ldUserService.login(response,loginDto));
    }

}
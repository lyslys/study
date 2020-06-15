package com.controller.lightningdeal;

import com.controller.BaseController;
import com.model.vo.LoginVo;
import com.model.result.Result;
import com.service.MiaoshaUserService;
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
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "lightningdeal/login";
    }

    @RequestMapping("/do_login")
    @ResponseBody

    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        //登录
        String token = miaoshaUserService.login(response, loginVo);
        return Result.success(token);
    }
}
package com.controller.lightningdeal;

import com.controller.BaseController;
import com.model.dto.LoginDto;
import com.model.result.CodeMsg;
import com.model.result.Result;
import com.service.LdUserService;
import com.utils.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


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
    public Result<Boolean> doLogin(LoginDto loginDto) {

        log.info(loginDto.toString());

        if (StringUtils.isEmpty(loginDto.getMobile())){
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }

        if (StringUtils.isEmpty(loginDto.getPassword())){
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }

        if(!ValidatorUtil.isMobile(loginDto.getMobile())){
            return Result.error(CodeMsg.MOBILE_ERROR);
        }

        //登录
        CodeMsg codeMsg =ldUserService.login(loginDto);

        if(codeMsg.getCode() == 0){
            return Result.success(true);
        }else{
            return Result.error(codeMsg);
        }

    }

}
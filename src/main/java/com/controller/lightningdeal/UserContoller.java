package com.controller.lightningdeal;

import com.controller.BaseController;
import com.model.dto.LoginDto;
import com.model.miaosha.LdUser;
import com.model.result.Result;
import com.service.LdUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "/user")
public class UserContoller extends BaseController implements InitializingBean {

    @RequestMapping("/info")
    @ResponseBody
    public Result<LdUser> info(Model model, LdUser user) {
        model.addAttribute("user", user);
        return Result.success(user);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我是启动的时候加载的-----在Contoller实现InitializingBean接口-------666666666666666666666666666666666666");
    }
}
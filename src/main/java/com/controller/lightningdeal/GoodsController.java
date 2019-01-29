package com.controller.lightningdeal;

import com.model.LdUser;
import com.service.LdUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	LdUserService ldUserService;

    @RequestMapping("/to_list")
    public String list(HttpServletResponse response, Model model,
                       @CookieValue(value = LdUserService.COOK1_NAME_TOKEN,required = false) String cookieToken,
                       @RequestParam(value = LdUserService.COOK1_NAME_TOKEN,required = false) String paramToken) {
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)){
            return "lightningdeal/login";
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        LdUser ldUser = ldUserService.getByToken(response,token);
    	model.addAttribute("user", ldUser);
        return "lightningdeal/goods_list";
    }
    
}

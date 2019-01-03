package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/admin")
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "manage/index/index";
    }

}
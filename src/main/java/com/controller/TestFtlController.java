package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestFtlController {

    @Autowired
    private Resource resource;

    @RequestMapping("studyIndex")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("resource",resource);
        return "studyIndex";
    }

    @RequestMapping("/indexfr")
    public String indexfr(ModelMap modelMap) {
        modelMap.addAttribute("resource",resource);
        return "fr/indexfr";
    }

}

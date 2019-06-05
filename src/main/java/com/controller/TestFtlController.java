package com.controller;

import com.utils.FileUtil;
import com.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class TestFtlController {

    @Autowired
    private Resource resource;

    @Value("${server.port}")
    private String port;

    @Value("${file.path}")
    private String filePath;

    @RequestMapping("studyIndex")
    public String studyIndex(ModelMap modelMap) {
//        modelMap.addAttribute("resource",resource);
        modelMap.addAttribute("filePath", filePath);
        return "studyIndex";
    }

    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("ip", IpUtils.getOuterNetIp() + ":" + port);
        return "ip";
    }

    @RequestMapping("/indexfr")
    public String indexfr(ModelMap modelMap) {
        modelMap.addAttribute("resource", resource);
        return "fr/indexfr";
    }

    @RequestMapping("/v_list")
    public String vList(ModelMap modelMap)throws Exception {
        File dirFile = new File(filePath);
        FileUtil.DirAll(dirFile,dirFile.getPath());
        modelMap.addAttribute("vList", FileUtil.dirAllStrArr);
        return "studyIndex";
    }

}

package com.controller;

import com.model.result.CodeMsg;
import com.model.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @Value("${file.path}")
    private String filePath;

    @RequestMapping("file_upload")
    public String fileUpload() {
        return "fr/upload";
    }

    @RequestMapping("single_file_upload")
    @ResponseBody
    public Result<Boolean> singleFileUpload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return Result.error(CodeMsg.FILE_NOT_EXIST);
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath +"/"+ file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.success(true);
    }

}
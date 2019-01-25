package com.controller;

import com.model.LdUser;
import com.model.result.CodeMsg;
import com.model.result.Result;
import com.service.LdUserService;
import com.utils.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sample")
public class SampleContoller extends BaseController {

    @Autowired
    private LdUserService ldUserService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/hello")
    public Result<String> hello() {
        return Result.success("helloJUC");
    }

    @RequestMapping("/helloError")
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    public Result<LdUser> dbGet() {
        LdUser ldUser = ldUserService.getById(1);
        return Result.success(ldUser);
    }

    @RequestMapping("/db/tx")
    public Result<Boolean> dbTx() {
        ldUserService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    public Result<Long> redisGet() {
        Long vl = redisService.get("k",Long.class);
        return Result.success(vl);
    }

    @RequestMapping("/redis/set")
    public Result<String> redisSet() {
        redisService.set("k3","hello,恭喜发财");
        String str = redisService.get("k3",String.class);
        return Result.success(str);
    }

}
package com.controller;

import com.model.LdUser;
import com.model.result.CodeMsg;
import com.model.result.Result;
import com.service.LdUserService;
import com.utils.redis.RedisService;
import com.utils.redis.prefix.LdUserKey;
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
    public Result<LdUser> redisGet() {
        LdUser ldUser = redisService.get(LdUserKey.getById,""+1, LdUser.class);
        return Result.success(ldUser);
    }

    @RequestMapping("/redis/set")
    public Result<Boolean> redisSet() {
        LdUser ldUser = new LdUser();
        ldUser.setId(1L);
        ldUser.setName("111111");
        redisService.set(LdUserKey.getById,""+1,ldUser);
        return Result.success(true);
    }

}
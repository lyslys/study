package com.controller;

import com.model.miaosha.MiaoshaUser;
import com.model.result.CodeMsg;
import com.model.result.Result;
import com.rabbitmq.MQSender;
import com.service.MiaoshaUserService;
import com.utils.redis.RedisService;
import com.utils.redis.MiaoshaUserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sample")
public class SampleContoller extends BaseController {

    @Autowired
    private MiaoshaUserService miaoUserService;

    @Autowired
    private RedisService redisService;

//    @Autowired
    private MQSender sender;

//    @RequestMapping("/mq")
//    @ResponseBody
//    public Result<String> mq() {
//        sender.send("hello,word");
//        return Result.success("helloword");
//    }
//
//    @RequestMapping("/mq/topic")
//    @ResponseBody
//    public Result<String> topic() {
//        sender.sendTopic("hello,word");
//        return Result.success("helloword");
//    }
//
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public Result<String> fanout() {
//		sender.sendFanout("hello,imooc");
//        return Result.success("Hello，world");
//    }
//
//    @RequestMapping("/mq/header")
//    @ResponseBody
//    public Result<String> header() {
//		sender.sendHeader("hello,imooc");
//        return Result.success("Hello，world");
//    }

    @RequestMapping("/hello")
    public Result<String> hello() {
        return Result.success("helloJUC");
    }

    @RequestMapping("/helloError")
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    public Result<MiaoshaUser> dbGet() {
        MiaoshaUser miaoshaUser = miaoUserService.getById(1);
        return Result.success(miaoshaUser);
    }

    @RequestMapping("/db/tx")
    public Result<Boolean> dbTx() {
        miaoUserService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    public Result<MiaoshaUser> redisGet() {
        MiaoshaUser MiaoshaUser = redisService.get(MiaoshaUserKey.getById,""+1, MiaoshaUser.class);
        return Result.success(MiaoshaUser);
    }

    @RequestMapping("/redis/set")
    public Result<Boolean> redisSet() {
        MiaoshaUser MiaoshaUser = new MiaoshaUser();
        MiaoshaUser.setId(1L);
        MiaoshaUser.setNickname("111111");
        redisService.set(MiaoshaUserKey.getById,""+1,MiaoshaUser);
        return Result.success(true);
    }

}
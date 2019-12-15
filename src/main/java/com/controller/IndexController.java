package com.controller;

import com.learn.jvm.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping(value = "/admin")
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "manage/index/index";
    }


    @RequestMapping("/user/process")
    @ResponseBody
    public String processUserData() throws InterruptedException {
        ArrayList<User> users = queryUsers();

        for (User user: users) {
            System.out.println("user:" + user.toString());
        }
        return "end";
    }

    /**
     * 模拟批量查询用户场景
     * @return
     */
    private ArrayList<User> queryUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            users.add(new User(i,"zhuge"));
        }
        return users;
    }


    ThreadPoolExecutor pool = new ThreadPoolExecutor(
            10000,
            100000,
            3,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardPolicy());

    @RequestMapping("testThread")
    @ResponseBody
    public String testThread() {

        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("---ok->");

        return "ok";
    }
}
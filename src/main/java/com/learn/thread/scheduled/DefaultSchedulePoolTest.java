package com.learn.thread.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DefaultSchedulePoolTest {
    public static void main(String[] args) {


        ScheduledExecutorService pool = Executors.newScheduledThreadPool(6);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟执行");
            }
        },1, TimeUnit.SECONDS);


        /**
         * 这个执行周期是固定，不管任务执行多长时间，每过3秒中就会产生一个新的任务
         */
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                //这个业务逻辑需要很长的时间，定时任务去统计一张数据上亿的表，财务财务信息
                //30
                System.out.println("重复执行");
            }
        },1,3,TimeUnit.SECONDS);

        /**
         * 假设12点整执行第一次任务12:00 01s
         * 12:30 04 产生新的任务
         */
        pool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("重复执行2");
            }
        },1,3,TimeUnit.SECONDS);

    }
}

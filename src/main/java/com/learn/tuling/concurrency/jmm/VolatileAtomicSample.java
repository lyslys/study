package com.learn.tuling.concurrency.jmm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 原子性
 */
public class VolatileAtomicSample {

    private static int counter = 0;
    static Object object = new Object();
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
//                    reentrantLock.lock();
                    UnsafeInstance.reflectGetUnsafe().monitorEnter(object);
                        counter++;
                    UnsafeInstance.reflectGetUnsafe().monitorExit(object);
//                    reentrantLock.unlock();
                    //不是一个原子操作,第一轮循环结果是没有刷入主存，这一轮循环已经无效
                    //1 load counter 到工作内存
                    //2 add counter 执行自加
                    //其他的代码段？
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }

}

package com.learn.thread.batch.demo;


/**
 * 当前线程让给另一个线程
 */
public class TestJoin {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("t1----> i:"+i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2----> i:"+i);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3----> i:"+i);
                }
            }
        });

        t1.start();
        System.out.println("t1执行中.........");
        t1.join();
        System.out.println("t1执行完毕");
        t2.start();
        System.out.println("t2执行中.........");
        t2.join();
        System.out.println("t2执行完毕");
        t3.start();
        System.out.println("t3执行中.........");
        t3.join();
        System.out.println("t3执行完毕");
        System.out.println("主线程执行完毕");
    }

}

package com.learn.thread;

/**
 * 进程：正在进行中的程序（直译）
 *
 * 线程：就是进程中一个负责程序执行的控制单元（执行路径）
 * 一个进程中可以多执行路径，称之为多线程。
 *
 * 一个进程中至少要有一个线程。
 *
 * 开启多个线程是为了同时运行多部分代码。
 *
 * 每一个线程都有自己运行的内容，这个内容可以称为线程要执行的任务。
 *
 *
 */

class Demo{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("demo ok");
    }
}


public class TestThread {

    public static void main(String[] args) {


        System.out.println(new Demo().hashCode());

        new Demo();
        new Demo();
        System.gc();
        System.out.println("hello word!");
    }
}

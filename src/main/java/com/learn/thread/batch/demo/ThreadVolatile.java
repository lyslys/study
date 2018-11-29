package com.learn.thread.batch.demo;

class ThreadVolatileDemo extends Thread{

    public boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行...");
        while (flag){
        }
        System.out.println("子线程开始执行...");
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}

public class ThreadVolatile {

    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(3000);
        threadVolatileDemo.setFlag(false);
        System.out.println("flag已经修改为false");
        Thread.sleep(1000);
        System.out.println(threadVolatileDemo.flag);
    }

}

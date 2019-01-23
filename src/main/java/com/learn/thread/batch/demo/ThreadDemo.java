package com.learn.thread.batch.demo;

class ThredTrain implements Runnable{

    //总共有一百张火车票
    private int trainCount = 100;

    @Override
    public void run() {
        while (trainCount > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //出售火车票
            sale();

        }
    }

    public  void sale() {
        synchronized (this) {
            if (trainCount > 0) {
                System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - trainCount + 1) + "票");
                trainCount--;
            }
        }

    }

}

public class ThreadDemo {

    public static void main(String[] args) {
        ThredTrain thredTrain = new ThredTrain();
        Thread t1 = new Thread(thredTrain,"窗口①");
        Thread t2 = new Thread(thredTrain,"窗口②");
//        t1.setDaemon(true);
        t1.start();
//        t2.setDaemon(true);
        t2.start();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完毕");
    }

}

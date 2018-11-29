package com.learn.thread.batch.lock;


class StopThreadDemo extends Thread{

    private volatile boolean flag = true;

    @Override
    public synchronized void run() {
        System.out.println("子线程开始执行");
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
                stopStopThreadDemo();
            }
        }
        System.out.println("子线程执行结束");
    }

    public void stopStopThreadDemo(){
        this.flag = false;
    }

}

public class StopThread {

    public static void main(String[] args) throws InterruptedException {

        StopThreadDemo stopThreadDemo = new StopThreadDemo();
        stopThreadDemo.start();

        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("我是主线程 i："+i);
            if(i==6){
                stopThreadDemo.interrupt();
//                stopThreadDemo.stopStopThreadDemo();
            }
        }

    }
}

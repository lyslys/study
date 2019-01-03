package com.learn.thread.batch.demo;

class ThreadTrain3 implements Runnable {
    // 总共有一百张火车 当一变量被static修饰的话存放在永久区，当class文件被加载的时候就会被初始化。
    private static int train1Count = 2000;
    private Object oj = new Object();
    public boolean flag = true;

    @Override
    public void run() {

        // 为了能够模拟程序一直在抢票的话。 where
        if (flag) {
            //执行同步代码块this锁
            while (true) {

                synchronized (oj) {
                    sale();
                }

            }
        }else{
            // 同步函数
            while (true) {

                // 出售火車票
                sale();
            }
        }

    }

    public synchronized void sale() {
        synchronized (oj) {
            if (train1Count > 0) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println(Thread.currentThread().getName() + ",出售第" + (2000 - train1Count + 1) + "票");
                train1Count--;
            }
        }

    }


}

public class ThreadDemo3 {

    public static void main(String[] args) throws InterruptedException {
        ThreadTrain3 threadTrain3 = new ThreadTrain3();
        Thread t1 = new Thread(threadTrain3, "第一个窗口");
        Thread t3 = new Thread(threadTrain3, "第二个窗口");
        t1.start();
        Thread.sleep(40);
        threadTrain3.flag=false;
        t3.start();
        System.out.println("主线程执行完");


     //   threadTrain3.getState();
    }

}

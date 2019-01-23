package com.learn.thread.batch.demo;

class ThreadTrain2 implements Runnable {
    // 总共有一百张火车 当一变量被static修饰的话存放在永久区，当class文件被加载的时候就会被初始化。
    private static int train1Count = 2000;
    private Object oj = new Object();
    public boolean flag = true;

    @Override
    public void run() {

        // 为了能够模拟程序一直在抢票的话。 where
        if (flag) {
            //执行同步代码块this锁

            while (train1Count>0) {
                synchronized (oj) {
                    if(train1Count>0){
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        System.out.println(Thread.currentThread().getName()+ ",出售第" + (2000 - train1Count + 1) + "票");
                        train1Count--;
                    }
                }

            }
        }else{
            // 同步函数
            while (train1Count>0) {

                // 出售火車票
                sale();
            }
        }

    }

    public synchronized void sale() {

        System.out.println("22222222222222");

        if (train1Count > 0) {
            try {
                Thread.sleep(50000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(Thread.currentThread().getName() + ",出售第" + (2000 - train1Count + 1) + "票");
            train1Count--;
        }

    }
}

public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException {

       /* Thread t3 = new Thread(new Runnable(){

              int i = 20;

            @Override
            public void run() {
                while (i>0){
                    System.out.println("6666666666");
                    i--;
                }
            }
        });

        t3.start();*/

        ThreadTrain2 threadTrain2 = new ThreadTrain2();
        Thread t1 = new Thread(threadTrain2, "第一个窗口");
        Thread t2 = new Thread(threadTrain2, "第二个窗口");
        t2.setPriority(10);
        t1.setPriority(1);
        t1.start();
        Thread.sleep(40);
        threadTrain2.flag=false;
        t2.start();

//        System.out.println("主线程执行完了");

    }

}

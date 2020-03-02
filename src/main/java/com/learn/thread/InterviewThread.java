package com.learn.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 多线程的面试
 */
public class InterviewThread {

}


/**Z
 *  如何实现处理线程的返回值
 */
class CycleWait implements Runnable{

    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();

        //①主线程等待法
    /*    while (cw.value == null){
            Thread.currentThread().sleep(1000);
        }*/


        //②使用join阻塞主线程方法，让子线程执行完
        t.join();

        System.out.println("value : "+cw.value);

        t.start();
    }

}

/**
 * ③通过Callablw接口实现：通过FutureTask 或者 线程池获取
 */
class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}

class FutureTaskDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
            if(!task.isDone()){
            System.out.println("还没完成");
        }
        System.out.println("task return: "+task.get());
    }
}

class ThreadPoolDemo{
    public static void main(String[] args) {

        //使用线程池实现
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("还没完成");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedThreadPool.shutdown();
        }
    }
}

/**
 * ---------------------------分割线--------------------------------->
 */

/**
 * sleep和wait的区别
 */
class WaitSleepDemo{
    public static void main(String[] args) {

        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("thread A is done");
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try{
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
//                        Thread.sleep(10);
//                        lock.wait(1000);
                        lock.notifyAll();
                        Thread.yield();
                        Thread.sleep(2000);
                        System.out.println("thread B is done");
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}


/**
 * ---------------------------分割线--------------------------------->
 */


/**
 * 如何中断线程
 */
class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable interruptTask = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    //在正常运行任务时，经常检查本线程的中断标志位，如果被设置了中断标志就自行停止线程
                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(100); // 休眠100ms
                        i++;
                        System.out.println(Thread.currentThread().getName() + " (" + Thread.currentThread().getState() + ") loop " + i);
                    }
                } catch (InterruptedException e) {
                    //在调用阻塞方法时正确处理InterruptedException异常。（例如，catch异常后就结束线程。）
                    System.out.println(Thread.currentThread().getName() + " (" + Thread.currentThread().getState() + ") catch InterruptedException.");
                }
            }
        };
        Thread t1 = new Thread(interruptTask, "t1");
        System.out.println(t1.getName() +" ("+t1.getState()+") is new.");

        t1.start();                      // 启动“线程t1”
        System.out.println(t1.getName() +" ("+t1.getState()+") is started.");

        // 主线程休眠300ms，然后主线程给t1发“中断”指令。
        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

        // 主线程休眠300ms，然后查看t1的状态。
        Thread.sleep(300);
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
    }
}


/**
 * ---------------------------分割线--------------------------------->
 */


/**
 * 如何中断线程
 */

class SyncThread implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.startsWith("A")) {
            async();
        } else if (threadName.startsWith("B")) {
            syncObjectBlock1();
        } else if (threadName.startsWith("C")) {
            syncObjectMethod1();
        } else if (threadName.startsWith("D")) {
            syncClassBlock1();
        } else if (threadName.startsWith("E")) {
            syncClassMethod1();
        }

    }

    /**
     * 异步方法
     */
    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "_Async_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_Async_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法中有 synchronized(this|object) {} 同步代码块
     */
    private void syncObjectBlock1() {
        System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * synchronized 修饰非静态方法
     */
    private synchronized void syncObjectMethod1() {
        System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void syncClassBlock1() {
        System.out.println(Thread.currentThread().getName() + "_SyncClassBlock1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (SyncThread.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "_SyncClassBlock1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "_SyncClassBlock1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized static void syncClassMethod1() {
        System.out.println(Thread.currentThread().getName() + "_SyncClassMethod1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_SyncClassMethod1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_SyncClassMethod1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class SyncDemo {
    public static void main(String... args) {
//        SyncThread syncThread = new SyncThread();
        Thread A_thread1 = new Thread( new SyncThread(), "A_thread1");
        Thread A_thread2 = new Thread( new SyncThread(), "A_thread2");
        Thread B_thread1 = new Thread( new SyncThread(), "B_thread1");
        Thread B_thread2 = new Thread( new SyncThread(), "B_thread2");
        Thread C_thread1 = new Thread( new SyncThread(), "C_thread1");
        Thread C_thread2 = new Thread( new SyncThread(), "C_thread2");
        Thread D_thread1 = new Thread( new SyncThread(), "D_thread1");
        Thread D_thread2 = new Thread( new SyncThread(), "D_thread2");
        Thread E_thread1 = new Thread( new SyncThread(), "E_thread1");
        Thread E_thread2 = new Thread( new SyncThread(), "E_thread2");
        A_thread1.start();
        A_thread2.start();
        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();
        D_thread1.start();
        D_thread2.start();
        E_thread1.start();
        E_thread2.start();
    }
}


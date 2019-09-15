package com.learn.thread.createway;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestCreate {


    public void test01(){

    }
}


//方法一：继承Thread类，作为线程对象存在（继承Thread对象）
class Test01 extends Thread{
    @Override
    public void run() {

        int i=0;
        while (!Thread.interrupted()){
            System.out.println("继承Thread类执行方法....");
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test01 test01 = new Test01();
        test01.start();
        Thread.sleep(5000);
//        test01.interrupt();
    }
}


//方法二：实现runnable接口，作为线程任务存在
class Test02 implements Runnable{
    @Override
    public void run() {
        int i=0;
        while (!Thread.interrupted()){
            System.out.println("继承Thread类执行方法....");
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Test02());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}

//方法三：匿名内部类创建线程对象
class Test03 {

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(()-> {
                System.out.println("匿名内部类创建线程对象");
        });
        thread.start();
    }

}


//方法三A：创建带返回值的线程
class Test03A implements Callable<String> {

    public static void main(String[] args) throws Exception {

        FutureTask futureTask = new FutureTask(new Test03A());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

    }

    @Override
    public String call() throws Exception {
        System.out.println("回调了.....");
        return "100";
    }
}

//方法五：定时器Timer
class Test05  {

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器Timer");
            }
        }, 0,3000);
    }

}

//方法六：线程池创建线程
class Test06  {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0;i<10;i++){
            executor.execute(new Test01());
        }

        executor.shutdown();

    }

}

//利用java8新特性 stream 实现并发
class Test07  {

    public static void main(String[] args) throws Exception {

        List<Integer> values = Arrays.asList(10,20,30,40);
        //parallel 平行的，并行的
        int result = values.parallelStream().mapToInt(p -> p*2).sum();
        System.out.println(result);
        //怎么证明它是并发处理呢
        values.parallelStream().forEach(p-> System.out.println(p));

    }

}


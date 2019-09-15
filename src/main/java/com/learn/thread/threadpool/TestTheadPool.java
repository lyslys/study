package com.learn.thread.threadpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestTheadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.execute(new MyTask(i));
            System.out.println("线程池中线程数目:" + threadPoolExecutor.getPoolSize() + ",队列中等待执行的任务数目"
                    + threadPoolExecutor.getQueue().size() + ",已执行完的任务数目：" + threadPoolExecutor.getCompletedTaskCount());
        }

        threadPoolExecutor.shutdown();

    }
}

class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task" + taskNum);
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task" + taskNum + "执行完毕");

    }
}


class TestException {
    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("a"));
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("a2"))
        ){

        } catch (Exception e)  {

        }


    }
}

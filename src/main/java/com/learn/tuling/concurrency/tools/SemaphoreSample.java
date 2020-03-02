package com.learn.tuling.concurrency.tools;

import java.util.concurrent.Semaphore;

/**
 * 信号量 限流
 */
public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i=0;i<6;i++){
            new Thread(new Task(semaphore,"yangguo+"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore,String tname){
            this.semaphore = semaphore;
            this.setName(tname);
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(2000);

                semaphore.release();
//                System.out.println(Thread.currentThread().getName()+":release() at time:"+System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

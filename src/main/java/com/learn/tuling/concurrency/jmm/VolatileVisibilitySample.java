package com.learn.tuling.concurrency.jmm;

/**
 * 可见性
 */
public class VolatileVisibilitySample {

    private volatile boolean  initFlag = false;
    static Object object = new Object();

    public void refresh(){
        this.initFlag = true;
        String threadname = Thread.currentThread().getName();
        System.out.println("线程："+threadname+":修改共享变量initFlag");
    }

    public void load(){
        String threadname = Thread.currentThread().getName();
        int i=0;
        while (!initFlag){
            synchronized (object){
                i++;
            }
        }
        System.out.println("线程："+threadname+"当前线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args){
        VolatileVisibilitySample sample = new VolatileVisibilitySample();
        Thread threadA = new Thread(()->{
            sample.refresh();
        },"threadA");

        Thread threadB = new Thread(()->{
            sample.load();
        },"threadB");

        threadB.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }

}

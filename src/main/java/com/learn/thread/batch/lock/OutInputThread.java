package com.learn.thread.batch.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res{
    public String userName;
    public String sex;
    public boolean flag = false;
    Lock lock = new ReentrantLock();
}

class Out extends Thread{

    Res res;
    Condition condition;

    public Out (Res res,Condition condition){
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {

        int count = 0;

        while (true){

            try {

                res.lock.lock();

                if(res.flag){
                    condition.await();
                }

                if(count == 0){
                    res.userName = "小红";
                    res.sex = "女";
                }else{
                    res.userName = "小明";
                    res.sex = "男";
                }

                count =(count + 1) % 2;

                res.flag = true;
                condition.signal();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }

        }
    }

}

class Input extends Thread{

    Res res;
    Condition condition;

    public Input (Res res,Condition condition){
        this.res = res;
        this.condition = condition;
    }


    @Override
    public void run() {
        while (true){

            try {

                res.lock.lock();

                if(!res.flag){
                    condition.await();
                }

                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
                condition.signal();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }

        }
    }
}

public class OutInputThread {

    public static void main(String[] args) throws InterruptedException {

      /*  Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("1000"+i);
                }
            }
        });

        t.start();
        t.join();*/

        Res res = new Res();
        Condition condition = res.lock.newCondition();
        Out out = new Out(res,condition);
        Input input = new Input(res,condition);
        out.start();
        input.start();
    }

}

package com.learn.thread.batch.lock;

class ResNumber{

    public  int count = 0;

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){

        @Override
        protected Integer initialValue() {
            return 0;
        }

    };

    public String getNumber(){
        count = threadLocal.get()+1;
        threadLocal.set(count);
        return  count + "";
    }

}


class LocalThreadDemo extends Thread{

    private ResNumber resNumber;

    public LocalThreadDemo(ResNumber resNumber){
        this.resNumber = resNumber;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(getName()+","+"Number:"+resNumber.getNumber());
        }

    }
}


public class ThreadLocalDemo01 {

    public static void main(String[] args) {
        ResNumber resNumber = new ResNumber();
        LocalThreadDemo t1 = new LocalThreadDemo(resNumber);
        LocalThreadDemo t2 = new LocalThreadDemo(resNumber);
        LocalThreadDemo t3 = new LocalThreadDemo(resNumber);
        t1.start();
        t2.start();
        t3.start();

        float a = 10;
        float b = 3;

        System.out.println(a/b);

    }

}

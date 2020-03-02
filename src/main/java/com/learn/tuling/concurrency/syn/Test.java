package com.learn.tuling.concurrency.syn;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

    StringBuffer stb = new StringBuffer();

    StringBuilder strb = new StringBuilder();

    public void test1(){
        //jvm的优化，锁的粗化
        stb.append("1");

        stb.append("2");

        stb.append("3");

        stb.append("4");
    }

    /**
     * 锁的消除
     */
    public void test2(){
        //jvm的优化，JVM不会对同步块进行加锁
        synchronized (new Object()) {
            //伪代码：很多逻辑
            //jvm是否会加锁？
            //jvm会进行逃逸分析
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        ReentrantLock reentrantLock = new ReentrantLock(true);
    }
}

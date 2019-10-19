package com.learn.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {


    //‐Xms10M ‐Xmx10M ‐XX:+PrintGCDetails ‐XX:+HeapDumpOnOutOfMemoryError ‐XX:HeapDumpPath=D:\jvm.dump

    public static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {

        test();
/*
        ExecutorService pools = Executors.newFixedThreadPool(600);
        List<Object> list = new LinkedList<>();
        int i = 0;
        int j = 0;

        for (int k = 0; k < 60; k++) {
            final int kk = k;
            pools.execute(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "k" + kk);
                }
            });
        }

        try {
            while (true) {
                list.add(new User(i, UUID.randomUUID().toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
*/

    }


    public static void test() {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
//            new User(j--, UUID.randomUUID().toString());
        }
    }
}

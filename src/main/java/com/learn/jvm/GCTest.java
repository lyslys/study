package com.learn.jvm;

import com.model.User;

import java.lang.ref.SoftReference;

public class GCTest {
    public static void main(String[] args) throws InterruptedException {
         byte[] allocation1, allocation2, allocation3, allocation4, allocation5,allocation6;

         allocation1 = new byte[6000000 * 1024];
     /*   allocation2 = new byte[8000 * 1024];
         allocation3 = new byte[1000 * 1024];
         allocation4 = new byte[1000 * 1024];
         allocation5 = new byte[1000 * 1024];
         allocation6 = new byte[1000 * 1024];*/

        System.out.println(allocation1.length);
        Thread.sleep(Integer.MAX_VALUE);

        SoftReference<User> softReference = new SoftReference<User>(new User());

        softReference.get();

    }
}

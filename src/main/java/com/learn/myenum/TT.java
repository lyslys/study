package com.learn.myenum;

public class TT {
    @Override
    protected void finalize(){
        System.out.println("进行回收了");
    }
}

package com.learn.design.singleresponsibility;

public class Bird {
    public void mainMoveMode(String birdName){
        if("鸵鸟".equals(birdName)){
            System.out.println(birdName+"用脚走");
        }else {
            System.out.println(birdName+"用翅膀飞");
        }
    }
}


abstract class A{
    public void aa(){
        System.out.println("aa");
    }

    public abstract void vv();
}

package com.learn.tuling.designpattern.singleton;

public class LazySingleton {

    //添加volatile 防止指令重排，避免初始化对象只赋值了，对象不为空，属性还没有初始化的情况出现
    private static volatile LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(instance == null){
            //假如大量线程等待获取锁
            synchronized (LazySingleton.class){
                //避免T1 T2 .... 多个线程 重复创建对象
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}

class LazySingletonTest{
    public static void main(String[] args) {
        System.out.println(LazySingleton.getInstance());
    }
}
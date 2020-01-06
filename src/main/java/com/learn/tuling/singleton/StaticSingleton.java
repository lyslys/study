package com.learn.tuling.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类加载保证线程安全
 */
public class StaticSingleton {

    public static String name = "xxx";

    static {
        System.out.println("StaticSingleton");
    }

    private StaticSingleton(){

        if(SingletonHolder.instance!=null){
            throw new RuntimeException("单例不允许创建实例");
        }

        System.out.println(SingletonHolder.instance);
        System.out.println("66");
        System.out.println("init");
}

    private static class SingletonHolder{
        static {
            System.out.println("SingletonHolder");
        }
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

}

class StaticSingletonTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        System.out.println(StaticSingleton.name);

        Constructor<StaticSingleton> declaredConstructor = StaticSingleton.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);

        StaticSingleton staticSingleton = declaredConstructor.newInstance();

//        System.out.println(StaticSingleton.getInstance()==staticSingleton);

    }
}

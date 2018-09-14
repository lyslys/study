package com.patterns;

/**
 * lys
 * <p>
 * 2018年1月11日  上午11:07:53
 */
public enum Singleton {
    INSTANCE;
    private A a;


    Singleton() {
        a = new A();
        a.setStr("收到收到收到");
        System.out.println("枚举私有的构造方法");
    }

    public A getInstance() {
        return a;
    }

}

/**
 * 需要单例的类
 * <p>
 * lys
 * <p>
 * 2018年1月11日  上午11:10:05
 */
class A {

    private String str;

    public static void main(String[] args) {
        Singleton.INSTANCE.getInstance().dayin();
        Singleton.INSTANCE.getInstance().dayin();
        Singleton.INSTANCE.getInstance().setStr("ccc");
        Singleton.INSTANCE.getInstance().dayin();
        Singleton.INSTANCE.getInstance().dayin();
    }

    public void dayin(){
        System.out.println(str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class B {
    {
        System.out.println("我是构造代码块=======");
    }

    static {
        System.out.println("我是静态代码块=======");
    }

    B() {
        System.out.println("我是构造函数=========");
    }

    public void test() {
        System.out.println("我是普通代码块=========");
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println("我是main普通代码块=========");
    }
}



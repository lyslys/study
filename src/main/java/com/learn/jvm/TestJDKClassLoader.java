package com.learn.jvm;

public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

        B b = null;
        A a= null;
        new B();
    }
}

class A{

    public A(){
        System.out.println("intinal..............A");
    }

}

class B{

    public B(){
        System.out.println("intinal..............B");
    }

    public void dd (){
        int a  = 1;
        int b = 2;
        System.out.println("dd"+(a+b));
    }

}

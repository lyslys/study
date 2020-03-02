package com.learn.tuling.designpattern.singleton;

public enum EnumSingletion{
    INSTANCE;
    public void print(){
        System.out.println("xxx");
    }
}


class EnumSingletionTest{
    public static void main(String[] args) {
        EnumSingletion instance = EnumSingletion.INSTANCE;
        EnumSingletion instance1 = EnumSingletion.INSTANCE;

        instance.print();

        System.out.println(instance==instance1);
    }
}

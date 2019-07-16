package com.learn.jdk8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了");
            }
        });

        invokeCook(()->System.out.println("吃饭了6"));
    }

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }

}

interface Cook {
    public abstract void makeFood();
    default public void aa(){};
}


/**
 * -----> ②
 */
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Test02{
    public static void main(String[] args) {
        Person[] arr = {
          new Person("柳岩",38),
          new Person("迪丽热巴",18),
          new Person("古力娜扎",17),
        };

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

//        Arrays.sort(arr,(Person o1, Person o2)->{
//                return o1.getAge()-o2.getAge();
//        });

        //简化
        Arrays.sort(arr,(o1,o2)->o1.getAge()-o2.getAge());

        for(Person person : arr){
            System.out.println(person);
        }
    }
}

/**
 * -----> ③
 */
class Test03{


    public static void main(String[] args) {

        invokeCalc(10,20,new Calculator(){
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

//        invokeCalc(120,66,(int a, int b)->{
//                return a+b;
//        });

        //简化
        invokeCalc(222, 333, (a,b)->a-b);

    }


    public static  void invokeCalc(int a,int b,Calculator c){
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}

/*
    给定一个计算器Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值
 */
 interface Calculator {
    //定义一个计算两个int整数和的方法并返回结果
    public abstract int calc(int a,int b);
}
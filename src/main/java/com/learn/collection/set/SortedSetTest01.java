package com.learn.collection.set;

import java.util.*;

public class SortedSetTest01 {

    public static void main(String[] args) {

        Set ss = new TreeSet();
      //  Set ss = new HashSet();
        ss.add(10);
        ss.add(36);
        ss.add(30);
        ss.add(20);
        ss.add(60);
        ss.add(9);

        Iterator it = ss.iterator();
        while (it.hasNext()){
            Object element = it.next();
            System.out.println(element);
        }

        SortedSet strs = new TreeSet();
        strs.add("KOOL");
        strs.add("LUCY");
        strs.add("AMMM");
        strs.add("IOOO");
        strs.add("KING");

        it = strs.iterator();
        while (it.hasNext()){
            Object element = it.next();
            System.out.println(element);
        }

        Set userSet = new HashSet();
        userSet.add(new User(16));
        userSet.add(new User(20));
        userSet.add(new User(11));
        userSet.add(new User(9));
        userSet.add(new User(33));
        userSet.add(new User(66));


        it = userSet.iterator();
        while (it.hasNext()){
            Object element = it.next();
            System.out.println(element);
        }


        System.out.println("-------------------->");

        Set<User> userSet1 = new HashSet<User>();
        userSet1.add(new User("zhangsan",11));
        userSet1.add(new User("zhangsan",11));
        userSet1.add(new User("lisi",12));
        userSet1.add(new User("wangwu",11));

        System.out.println(userSet1.size());

    }

}

class User{

    private String name;
    private int age;

    public User(int age) {
        this.age = age;
    }

    public User(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

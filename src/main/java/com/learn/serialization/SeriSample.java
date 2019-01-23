package com.learn.serialization;

import java.io.*;

public class SeriSample {

    public static void main(String[] args) throws Exception {
//        writeObject();
         readObject();
    }

    public static void writeObject() throws IOException {
        Person per = new Person(23,"张三");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\per.obj"));
        oos.writeObject(per); //以字节码形式写入硬盘
    }

    public static void readObject() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\per.obj"));
        Person perObj = (Person) ois.readObject();
        System.out.println(perObj.getName()+":"+perObj.getAge());
    }

}

class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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

}

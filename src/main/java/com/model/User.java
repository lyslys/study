package com.model;


public class User{

    private String age;

    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String name;

    public String password;

    public User() {
    }

    public User(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


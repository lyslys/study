package com.learn.design.singleton;


//饿汉式（静态变量）
public class User {

    private static final  User user = new User();

    private User(){}

    public static User getInstance(){
        return  user;
    }

}

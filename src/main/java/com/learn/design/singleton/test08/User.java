package com.learn.design.singleton.test08;


import java.util.EnumMap;

//懒汉式（枚举）
enum User {
    USER;

    public void sayOk() {
        System.out.println("ok");
    }

}

class Test {
    public static void main(String[] args) {
        System.out.println("使用懒汉式（枚举）");
        User user = User.USER;
        User user1 = User.USER;
        System.out.println(user == user1);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        user.sayOk();

        EnumMap enumMap = new EnumMap(User.class);
        enumMap.put(User.USER, "6666");

    }
}

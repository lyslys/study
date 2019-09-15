package com.learn.design.singleton;

public class Test {
    public static void main(String[] args) {
        User user = User.getInstance();
        User user1 = User.getInstance();
        User user2 = User.getInstance();
        System.out.println(user==user1);
        System.out.println(user==user2);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        String s = new String();
        String s1 = new String();
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s == s1);
    }
}

package com.learn.design.singleton.test07;


//懒汉式（静态内部类）
public class User {

    private User() {
    }

    //该类中有一个静态属性 INSTANCE  调用getInstance方法时才会装载静态内部类， 类装载的时候，线程是安全的
    private static class UserInstance{
        private static final User user = new User();
    }

    public static User getInstance() {
        return UserInstance.user;
    }

}

class Test {
    public static void main(String[] args) {
        System.out.println("使用懒汉式（静态内部类）");
        User user = User.getInstance();
        User user1 = User.getInstance();
        User user2 = User.getInstance();
        System.out.println(user == user1);
        System.out.println(user == user2);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}

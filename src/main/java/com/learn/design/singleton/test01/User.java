package com.learn.design.singleton.test01;


//饿汉式（静态代码块）
public class User {

    private static final User user;

    static {
        user = new User();
    }

    private User(){}

    public static User getInstance(){
        return  user;
    }

}

class Test{
    public static void main(String[] args) {
        User user = User.getInstance();
        User user1 = User.getInstance();
        User user2 = User.getInstance();
        System.out.println(user==user1);
        System.out.println(user==user2);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}

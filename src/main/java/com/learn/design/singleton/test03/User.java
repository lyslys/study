package com.learn.design.singleton.test03;


//懒汉式（线程安全）
public class User {

    private static User user;

    private User(){}

    public synchronized static User getInstance(){
        if(user == null){
            user = new User();
        }
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

package com.learn.generic;

import com.model.User;

public class TestBox {

    public static void main(String[] args) {

        long j = 99999999999L;
        Box<User> box= new Box<User>(new User());
        Box<String> box2= new Box<String>("99");
        Box box3 = new Box(false);
        Box box5 = new Box(6.6);
        Box box6 = new Box(j);
        System.out.println(box.getT());
        System.out.println(box2.getT());
        System.out.println(box3.getT());
        System.out.println(box5.getT());
        System.out.println(box6.getT());

        System.out.println("--------------->");

        IBox bigBox = new BigBox();

        System.out.println(BigBox.digits);
        System.out.println(BigBox.digits);

        for (int i=0;i<10;i++){
            System.out.println(bigBox.next());
        }

        String str = new IBox<String>(){

            @Override
            public String next() {
                return "阿萨德阿萨德阿萨德阿萨德";
            }
        }.next();

        System.out.println(str);

        Runnable runnable = () -> {
            System.out.println("多线程");
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }
}

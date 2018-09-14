package com.learn.generic;

import com.model.User;

public class TestBox {

    public static void main(String[] args) throws Exception {

        long j = 99999999999L;
        Box<User> box= new Box<User>(new User());
        Box<String> box2= new Box<String>("99");
        Box box3 = new Box(false);
        Box box5 = new Box(6.6);
        Box box6 = new Box(j);
        System.out.println(box3.getT());
        System.out.println(box.getT());
        System.out.println(box2.getT());
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

        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        System.out.println("---------->");

//        getData(box);
        getData(box2);
        getData(box3);
        getData(box5);
        getData(box6);

        //------------>泛型方法

        User obj = (User) genericMethod(Class.forName("com.model.User"));
        obj.setAge("66");
        obj.setName("阿萨德");
        System.out.println(obj);
    }

    //  extends Number 只能是Number类及其子类
    //  super Number  与上面正好相反
    public static void getData(Box<? super String> data){
        System.out.println(data.getT());
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
}

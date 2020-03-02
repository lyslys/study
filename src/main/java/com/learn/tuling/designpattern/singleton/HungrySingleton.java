package com.learn.tuling.designpattern.singleton;

import java.io.*;


/**
 * -XX:+TraceClassLoading 查看类加载过程
 */
public class HungrySingleton implements Serializable {

    static final long serialVersionUID = 42L;

    private static HungrySingleton instance = new HungrySingleton();

    public static String name = "xxx";

    public static String name1 = "xxx";
    public static String name2 = "xxx";

    static {
        System.out.println("init");
    }

    private HungrySingleton(){
        System.out.println("构造函数");
    }

    public static HungrySingleton getInstance(){
        return instance;
    }

    public static boolean isTrue(){
        return instance != null;
    }

    Object readResolve() throws ObjectStreamException{
        return instance;
    }

}

class  HungrySingletonTest{

        public static void main(String[] args) {
//        HungrySingleton hungrySingleton=null;
//        Class<HungrySingleton> hungrySingletonClass = HungrySingleton.class;
//        System.out.println(HungrySingleton.name);

            HungrySingleton instance = HungrySingleton.getInstance();

//            try {
//                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test"));
//                oos.writeObject(instance);
//            }catch (Exception e){
//                e.printStackTrace();
//            }

            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test"));
                HungrySingleton o = (HungrySingleton) ois.readObject();
                System.out.println(instance==o);
            }catch (Exception e){
                e.printStackTrace();
            }


    }

}

package com.learn.myenum;


import java.util.ArrayList;
import java.util.List;

public class Test {

    public String name;

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        System.out.println(Day.monday);
        Day day = Day.monday;

        System.out.println("----------:"+day.compareTo(Day.wednesday));

        System.out.println(day.ordinal());
        System.out.println(day.toString());

        a(Day.saturday);

        Test t = new Test();

        t.name = "aaaaaa";
      /*  try {
            Test tt = (Test)t.clone();
            System.out.println(tt);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/

        System.out.println(day.getName());

        TT tt = new TT();

        tt = null;

//        System.gc();

      /*  Runtime r = Runtime.getRuntime();

        System.out.println(r.maxMemory()/2048/1024+"G");
        System.out.println(r.totalMemory()/2048/1024+"G");
        System.out.println(r.freeMemory()/2048/1024+"G");


        byte[] b  = new byte[(int)(r.maxMemory()/2)];
        byte[] b2  = new byte[(int)(r.maxMemory()/2)];*/

        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

        int yy = 22;
        Integer hh = new Integer(66);
        t.bb(hh);
        System.out.println("yy:"+hh);


        List<String> stringList = new ArrayList<>();

        t.bb(stringList);
        System.out.println(stringList);

        Integer i1 = 130;
        Integer i2 = 130;
        System.out.println(i1 == i2);

    }

    public  void bb(Integer i) {
        i = 6;
        System.out.println(i);
    }

    public  void bb(List list) {
        list.add("aaaaaaa666");
    }


    public static void a(Day day) {
        switch (day) {
            case monday:
                System.out.println("你输入星期一");
                break;
            case tuesday:
                System.out.println("你输入星期二");
                break;
            case wednesday:
                System.out.println("你输入星期三");
                break;
            default:
                System.out.println("最后");
        }
    }

}


abstract class CC {

}

class BB {

    private String name;

    public BB(String name) {
        this.name = name;
    }

}

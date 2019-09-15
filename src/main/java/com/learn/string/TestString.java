package com.learn.string;

import java.io.UnsupportedEncodingException;


public final class TestString  implements Runnable{

    private final char value[] = {'a'};

    public static void main(String[] args) throws UnsupportedEncodingException {

        byte [] value = new byte[]{65,66,22};
        char [] charValue = {'我','发','财','了'};

        String str1 = "abc"; //直接将字符串常量赋值给str （字符串常量池）

        String str2= new String();//无参数构造方法创建空对象
        String str3= new String("abc");
        System.out.println(new String(value,0,1));
        System.out.println(new String(charValue,0,2));
        String str6 = "abc66"; //直接将字符串常量赋值给str （字符串常量池）
        String str7 = "ccc"; //直接将字符串常量赋值给str （字符串常量池）

        System.out.println(str3.hashCode());
//        System.out.println(str1.hashCode());
//        System.out.println(str6.hashCode());
        System.out.println(str6.hashCode());

        System.out.println(str7.compareTo(str6));

        char a = 'a';
        char b = 'b';
        System.out.println(a-b);

        System.out.println(str6.charAt(1));
        System.out.println((char)str6.codePointAt(1));
        System.out.println(str6.length());
        System.out.println(value.length);
        str6.concat("9999999999");
        System.out.println(str6);
        System.out.println(str6.contains("c"));

        System.out.println(str6.startsWith("a"));
        System.out.println(str6.endsWith("6"));

        String str8 = "我发财了"; //直接将字符串常量赋值给str （字符串常量池）


        char [] aa = str8.toCharArray();
        byte [] bb = str8.getBytes("UTF-8");

        System.out.println("------------>");

//        for (byte vv:bb ) {
//            System.out.println((char)vv);
//        }
//
//        for (char aaA:aa ) {
//            System.out.print(aaA);
//        }
        System.out.println(aa.length);
        System.out.println(bb.length);

        System.out.println("------------>");

        String str9 ="aadfgddfagdf";

        System.out.println(str9.indexOf("d",6));
        System.out.println(str9.indexOf(97,3));

        //最后一次出现的位置
        System.out.println(str9.lastIndexOf("g",20));

        String str10 = "";
        System.out.println(str10.isEmpty());

        String str11 = "  我发财了我  发财了   ";

        System.out.println(str9.replace("aa", "发财"));
        System.out.println(str11.replace('财', '福'));
        System.out.println(str11);
        System.out.println(str11.replace("财", "福"));
        System.out.println(str11.replaceFirst("财", "福"));

        String str12 ="a-b-c-d";
        String [] aaaaaa = str12.split("-",3);
        for (String v: aaaaaa) {
            System.out.println(v);
        }

        System.out.println("------------>");

        System.out.println(str12.substring(2, 3)); //[2,3)
        System.out.println(str12.substring(2));

        System.out.println(str9.toUpperCase());

        System.out.println(str11.trim());

        StringBuilder stringBuilder = new StringBuilder("99999999999");
        System.out.println(stringBuilder.capacity());






        /**
         * 重写父类方法 要求
         * 1.方法名和参数要一致
         * 2.权限修饰符 可有大于等于父类的
         * 3.返回值 可有小于等于父类
         * 4. 异常个数和异常要小于等于父类
         */

  /*      String s1 = "abc";  //
        String s2 = "abc";
        String s3= new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  //false
        System.out.println(s3 == s4);  //false
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1.equals(s3)); //true
        System.out.println(s3.equals(s4)); //true*/



    }

    @Override
    public void run() {

    }
}

package com.learn.collection;

/**
 * 数组的概念 是一种容器，可以同时存放多个数据值
 * <p>
 * 数组的特点：
 * 1.数组是一种引用数据类型
 * 2.数组当中的多个数据，类型必须统一
 * 3.数组的长度在程序运行期间不可改变
 * <p>
 * <p>
 * 常见的初始化方式
 * 1.动态初始化（指定长度）
 * 2.静态初始化
 */
public class TestArray {

    public static void main(String[] args) {

        char [] chars = new char[10];
        System.out.println(chars[0]);

        String[] i = new String[10];
        System.out.println(i[0]);
        i[0] = "666";
        i[1] = "999";
        System.out.println(i[1]);

        String [] strings = new String[]{"hello","world"};
        System.out.println(strings.length);
        System.out.println(strings[0]);

        Double [] doubles = {6.6,7.8,7.99};
        System.out.println(doubles[0]);
        System.out.println(doubles.length);
    }

}

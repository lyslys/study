package com.learn.exception;


import java.util.Arrays;

/**
 *
 *  异常体系结构：
 *          Throwable(最顶层)
 *                  Error：出现的不能够处理的严重问题
 *                  Exception：可以处理的问题
 *
 *
 *
 *                  java.lang.RuntimeException的子类  运行期间的异常
 *                  java.lang.Exception的子类 编译期间异常
 */
public class TestException {

    public static void main(String[] args) {

        try {
            check(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void check(int fs){
        if(fs < 0 || fs > 100){
//            throw new RuntimeException("分数不正常");
            throw new MyException("分数不正常");
        }
        System.out.println("分数正常");
    }

    private static void c() {
        System.out.println(10/0);

//        FileWriter fileWriter = new FileWriter("aa.txt");
        try {
            int[]  arr1 = {1,2,3,4,5,6};
            int[]  arr2 = new int[arr1.length];

            System.arraycopy(arr1, 0, arr2, 0, arr1.length);

            System.out.println(Arrays.toString(arr2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void b() {
        try {
            System.out.println(10/0);
        }catch (ArithmeticException ae){
//            ae.printStackTrace();   类型和原因和位置
//            System.out.println(ae.getMessage()); 原因
            System.out.println(ae.toString());  // 类型和原因
        }
    }

    private static void a() {
        try {
            System.out.println(999);
//            System.out.println(10/0);
            System.out.println(888);
        }catch (ArithmeticException ae){
            System.out.println("hello");
        }finally {
            System.out.println(777);
        }

        System.out.println("666666666666");
    }

}

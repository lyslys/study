package com.learn.datastructure;

/**
 * 递归算法
 * 1.一定要有出口
 * 2.递归次数过多，有可能会造成栈内存溢出
 */
public class RecursionDemo {

    public static void main(String[] args) {

        System.out.println(factorial(5));
        System.out.println(factorial2(5));
    }

    //递归算法(调用)
    public static int factorial2(int num){

        if(num == 1){
            return 1;
        }

        return num*factorial2(num-1);
    }

    //阶乘
    public static int factorial(int num){
        int sum = num;
        int i = num-1;

        do{
            sum *=i;
            i--;
        }while (i>1);

        return sum;
    }

}

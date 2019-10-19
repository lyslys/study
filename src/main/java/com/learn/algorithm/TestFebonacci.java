package com.learn.algorithm;

/**
 * 斐波那契数列  1 1 2 3 5 8 13
 */
public class TestFebonacci {
    public static void main(String[] args) {


        System.out.println(5%2);

        System.out.println(febonacci(8));
    }

    public static int febonacci(int i){
        if(i == 1 || i == 2){
            return 1;
        }else {
            return febonacci(i-2)+febonacci(i-1);
        }
    }

}

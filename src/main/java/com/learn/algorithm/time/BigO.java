package com.learn.algorithm.time;

public class BigO {
    public static void main(String[] args) {
        int a = 1;  //运行1次 O(1)

        for (int i = 0; i < 3; i++) {   //运行4次 O(4)
            a = a + 1;   //运行3次 O(3)
        }

        int j = 0;

        int n = 1000;

        int i = 1;
        while (i <= n){
            i = i * 2;
            ++j;
        }

        System.out.println("执行了"+j+"次");






    }
}

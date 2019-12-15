package com.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 打扑克，往一个有序的数组 插入元素
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {9, 7, 8, 1, 0, 3, 2};
        int n = a.length;



        for (int i = 1; i < n; i++) {
            int data = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {//从尾到头
                        if(a[j] > data){
                            a[j+1] = a[j];    //数据往后移
                        }else {
                            break;
                }
            }
            a[j+1] = data;
            System.out.print("第"+i+"次的排序结果");
            System.out.println(Arrays.toString(a));
        }

    }
}

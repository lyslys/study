package com.learn.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序   两个数对比，大的往后移
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,2,9,6,1,0,7,5};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int [] arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

}

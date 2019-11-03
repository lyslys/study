package com.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void sort(int[] arr) {

        //取个中间位置
        int mid = arr.length / 2;

        //创建新的数组
        int[] temp = new int[arr.length];

        //第一个有序的开始下标
        int i = 0;

        //第二个有序的开始下标
        int j = mid + 1;

        //新数组的开始下标
        int k = 0;

        //条件：两个数组都还没有遍历完
        while (i <= mid && j < arr.length) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j < arr.length) {
            temp[k++] = arr[j++];
        }

        System.out.println(Arrays.toString(temp));


    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 6, 7, 9, 2, 5, 7, 8};
        sort(arr);
    }
}

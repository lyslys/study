package com.learn.algorithm;

/**
 * 查找算法  二分法查找
 */
public class TestBinarySearch {
    public static void main(String[] args) {

        int [] arr = new int[]{1,2,3,4,5,6,7,8,9};

        //目标元素
        int target = 6;

        //记录开始位置
        int begin = 0;

        //记录结束位置
        int end = arr.length-1;

        //记录中间位置
        int mid = (begin+end)/2;

        //记录目标位置
        int index = -1;

        //循坏查找
        while (true){

            System.out.println("begin:"+begin);
            System.out.println("end:"+end);

            System.out.println("mid:"+mid);

            if(begin > end){
                break;
            }

            if(arr[mid] == target){
                index = mid;
                break;
            }else {
                if(arr[mid] > target){
                    end = mid -1;
                }else{
                    begin = mid +1;
                }
                mid = (begin+end)/2;
            }
        }

        System.out.println("idnex:"+index);

    }
}

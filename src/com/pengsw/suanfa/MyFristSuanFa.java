package com.pengsw.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: pengsw
 * @Date: 2019-07-23 20:07
 * @Description:
 */

public class MyFristSuanFa {
    void xuanzhe(int [] list) {

        for (int i = 0; i < list.length; i++) {
            int max = 1;
            for (int j = i; j <list.length ; j++) {
                if (list[j] > max) {
                    max = list[j];
                    list [j] = list[i];
                    list [i] = max;
                }
            }
            //list[i] = max;
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }


    void maoPao(int [] list) {

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j <i ; j++) {
                if (list[j] > list [i]) {
                     int temp = list[j];
                    list [i] = temp;
                    list[j] = list [i];
                }
            }
            //list[i] = max;
        }


        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    void charu(int [] list) {
        for (int i = 1; i <list.length; i++) {
            for (int j =i; j > 0 ; j--) {
                if (list[j] > list [j-1]) {
                    int temp = list[j-1];
                    list [j-1] = list [j];
                    list [j] = temp;
                } else {
                    break;
                }
            }
        }


        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }


    void sort(int [] arr,int low,int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;
        int temp = arr[left]; //挖坑1：保存基准的值

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right]; //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (left < right && arr[left] <= temp) {
                left ++;
            }
            arr[right] = arr[left]; //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
        }
        arr[left] = temp; //基准值填补到坑3中，准备分治递归快排
        System.out.println("Sorting: " + Arrays.toString(arr));
        sort(arr, low, left-1);
        sort(arr, left + 1, high);
    }

    public static void main(String[] args) {
        int [] arr={1,15,6,7,9,4};
        new MyFristSuanFa().sort(arr,4,4);

    }
}


// j = 6    5 6 7 9 2 15
// j = 5    2 6 7 9 5 15
// j = 4


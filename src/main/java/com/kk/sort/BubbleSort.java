package com.kk.sort;

import com.kk.utils.TimeUtil;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        Date beginTieme = new Date();
        bubbleSortMethod(arr);
        TimeUtil.userTime(beginTieme);


    }

    private static void bubbleSortMethod(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }


}

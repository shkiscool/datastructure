package com.kk.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{101, 34, 119, 1};
        doSelectSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void doSelectSort(int [] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }


}

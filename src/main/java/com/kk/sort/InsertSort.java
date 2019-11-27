package com.kk.sort;

        import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1,1};
        inserSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void inserSort(int[] arr) {
        for (int i = 1;i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i-1;
            while(insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
        }
    }
}

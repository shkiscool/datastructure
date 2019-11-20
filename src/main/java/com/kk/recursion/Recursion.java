package com.kk.recursion;

public class Recursion {

    public static void main(String[] args) {
        test(5);
    }


    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }
}

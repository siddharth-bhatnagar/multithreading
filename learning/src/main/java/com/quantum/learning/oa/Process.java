package com.quantum.learning.oa;

import java.util.Arrays;

public class Process {

    public static void run() {


        char[] A = new char[]{'a','b','b','b','a','c','a','a','c'};
        int a[] = new int[]{0,0,1,2,2,3,3,4};
        int b[] = new int[]{1,2,8,3,4,5,6,7};
        int m=9;
        int q[] = new int[]{0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays
                .toString(
                new DiskStorage()
                        .solveQueries(9, A, a, b, m, q)));
    }
}

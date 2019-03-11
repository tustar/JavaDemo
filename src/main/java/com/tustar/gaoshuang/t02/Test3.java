package com.tustar.gaoshuang.t02;

/**
 * Created by tustar on 6/23/16.
 */
public class Test3 {

    static volatile int i, j;
    static void one() {
        i++;
        j++;
    }
    static void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}

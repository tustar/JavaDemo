package com.tustar.gaoshuang.t02;

/**
 * Created by tustar on 6/23/16.
 */
public class Test2 {

    static int i, j;
    static synchronized void one() {
        i++;
        j++;
    }
    static synchronized void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}

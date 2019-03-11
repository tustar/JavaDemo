package com.tustar.gaoshuang.t01;

/**
 * Created by tustar on 6/23/16.
 */
public class Count {

    private int num;

    public void count() {
        for (int i = 0; i <= 10; i++) {
            num += i;
        }
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }

//    public void count() {
//        int num = 0;
//        for (int i = 0; i <= 10; i++) {
//            num += i;
//        }
//        System.out.println(Thread.currentThread().getName() + "-" + num);
//    }
}

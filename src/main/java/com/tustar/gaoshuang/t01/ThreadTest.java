package com.tustar.gaoshuang.t01;

/**
 * Created by tustar on 6/23/16.
 */
public class ThreadTest {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            Count count = new Count();
//            @Override
//            public void run() {
//                count.count();
//            }
//        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Count count = new Count();
                count.count();
            }
        };
        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}

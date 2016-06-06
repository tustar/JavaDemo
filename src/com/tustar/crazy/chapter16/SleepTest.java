package com.tustar.crazy.chapter16;

import java.util.Date;

/**
 * Created by tustar on 6/6/16.
 */
public class SleepTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间: " + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/7/16.
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("12345678", 1000);
        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 800).start();
        new DrawThread("丙", account, 800).start();
        new DrawThread("丁", account, 800).start();
    }
}

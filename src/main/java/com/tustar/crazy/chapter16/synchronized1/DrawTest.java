package com.tustar.crazy.chapter16.synchronized1;

/**
 * Created by tustar on 6/10/16.
 */
public class DrawTest {

    public static void main(String[] args) {
        Account account = new Account("12345678", 0);
        new DrawThread("取钱者", account, 800).start();
        new DepositThread("存款者甲", account, 800).start();
        new DepositThread("存款者乙", account, 800).start();
        new DepositThread("存款者丙", account, 800).start();
    }
}

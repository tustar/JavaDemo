package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/7/16.
 */
public class DrawThread extends Thread {

    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAccount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAccount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }

}

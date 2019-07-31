package com.tustar.pattern.behavioral.tm;

public abstract class Account {

    public boolean validate(String account, String password) {
        System.out.println("账号:" + account);
        System.out.println("密码:" + password);
        if (account.equalsIgnoreCase("张无忌")
                && password.equalsIgnoreCase("123456")) {
            return true;
        }

        return false;
    }

    public abstract void calculateInterest();

    public void display() {
        System.out.println("显示利息!");
    }

    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("账户或密码错误");
        }

        calculateInterest();
        display();
    }
}

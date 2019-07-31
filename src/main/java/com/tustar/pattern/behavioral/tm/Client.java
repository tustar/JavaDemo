package com.tustar.pattern.behavioral.tm;

public class Client {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        account.handle("张无忌", "123456");
    }
}

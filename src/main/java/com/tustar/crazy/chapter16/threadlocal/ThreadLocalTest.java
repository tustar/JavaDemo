package com.tustar.crazy.chapter16.threadlocal;

/**
 * Created by tustar on 6/10/16.
 */
class Account {

    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}

class MyTest extends Thread {
    private Account account;

    public MyTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
            }
            System.out.println(account.getName() + " 账户的i值: " + i);
        }
    }
}

public class ThreadLocalTest {

    public static void main(String[] args) {
        Account account = new Account("初始名");
        new MyTest( "线程甲", account).start();
        new MyTest("线程乙", account).start();
    }
}

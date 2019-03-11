package com.tustar.lbw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tustar on 17-5-3.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        //创建一个锁对象 ,非公平锁
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        // 创建一个线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //设置一个账号，设置初始金额为10000
        Account account = new Account(10_000, lock, "6225 8888");
        //账号取钱10次，存钱10次，查询20次
        for (int i = 0; i < 10; i++) {
            Operation operation1 = new Operation(account, Type.TAKE);
            Operation operation2 = new Operation(account, Type.QUERY);
            Operation operation3 = new Operation(account, Type.SAVE);
            Operation operation4 = new Operation(account, Type.QUERY);
            executor.execute(operation1);
            executor.execute(operation2);
            executor.execute(operation3);
            executor.execute(operation4);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("账号" + account.getAccountNo() + ",最后金额为：" + account.getMoney());
    }
}

enum Type {
    TAKE, QUERY, SAVE
}

class Operation implements Runnable {

    private Account account; //账号
    Type type;

    Operation(Account account, Type type) {
        this.account = account;
        this.type = type;
    }

    @Override
    public void run() {
        ReadWriteLock readWriteLock = account.getLock();
        Lock writeLock = readWriteLock.writeLock();
        Lock readLock = readWriteLock.readLock();
        switch (type) {
            case TAKE:
                //每次取100元
                //获取写锁
                writeLock.lock();
                account.setMoney(account.getMoney() - 100);
                System.out.println("取走100元，账号" + account.getAccountNo() + "还有" + account.getMoney() + "元");
                writeLock.unlock();
                break;
            case QUERY:
                //获取读锁
                readLock.lock();
                System.out.println("查询账号" + account.getAccountNo() + "还有" + account.getMoney() + "元");
                readLock.unlock();
                break;
            case SAVE:
                //获取写锁
                writeLock.lock();
                account.setMoney(account.getMoney() + 100);
                System.out.println("存入100元，账号" + account.getAccountNo() + "还有" + account.getMoney() + "元");
                writeLock.unlock();
                break;
            default:
                break;
        }
    }
}

class Account {
    private int money; //账号上的钱
    private ReadWriteLock lock; //读写写
    private String accountNo; //账号

    public Account(int money, ReadWriteLock lock, String accountNo) {
        this.money = money;
        this.lock = lock;
        this.accountNo = accountNo;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ReadWriteLock getLock() {
        return lock;
    }

    public void setLock(ReadWriteLock lock) {
        this.lock = lock;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}

package com.tustar.crazy.chapter16;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tustar on 6/7/16.
 */
public class Account {

    private final ReentrantLock lock = new ReentrantLock();
    private String accountNo;
    private double blance;

    public Account() {
    }

    public Account(String accountNo, double blance) {
        this.accountNo = accountNo;
        this.blance = blance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBlance() {
        return blance;
    }

    public void setBlance(double blance) {
        this.blance = blance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.blance, blance) != 0) return false;
        return !(accountNo != null ? !accountNo.equals(account.accountNo) : account.accountNo != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNo != null ? accountNo.hashCode() : 0;
        temp = Double.doubleToLongBits(blance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo='" + accountNo + '\'' +
                ", blance=" + blance +
                '}';
    }

    public void draw(double drawAmount) {
        lock.lock();
        try {

            if (getBlance() >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票: " + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blance -= drawAmount;
                System.out.println("\t " + Thread.currentThread().getName() + "取完后余额为: " + getBlance());
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
            }
        } finally {
            lock.unlock();
        }
    }
}

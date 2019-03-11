package com.tustar.crazy.chapter16.synchronized1;

/**
 * Created by tustar on 6/7/16.
 */
public class Account {

    private String accountNo;
    private double blance;
    private boolean flag;

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

    public synchronized void draw(double drawAmount) {

        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " 取钱: " + drawAmount);
            blance -= drawAmount;
            System.out.println("账户余额为: " + blance);
            flag = false;
            notifyAll();
        }
    }

    public synchronized void deposit(double depositAmount) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " 存款: " + depositAmount);
            blance += depositAmount;
            System.out.println("账户余额为: " + blance);
            flag = true;
            notifyAll();
        }
    }
}

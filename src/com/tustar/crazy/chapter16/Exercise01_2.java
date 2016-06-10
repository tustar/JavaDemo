package com.tustar.crazy.chapter16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tustar on 6/10/16.
 */

public class Exercise01_2 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            for (int i = 1; i <= 52; i++) {
                lock.lock();
                try {
                    System.out.print(i);
                    if (i % 2 == 0) {
                        condition.signalAll();
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for (char i = 'A'; i <= 'Z'; i++) {
                lock.lock();
                try {
                    System.out.print(i);
                    condition.signalAll();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}

package com.tustar.gg.ch3;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            doLock(lock1, lock2);
            return;
        } else {
            doLock(lock2, lock1);
        }
    }

    private void doLock(ReentrantLock lock1, ReentrantLock lock2) {
        while (true) {
            if (lock1.tryLock()) {
                try {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                    if (lock2.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getId() + ":My Job done");
                            return;
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock tryLock1 = new TryLock(1);
        TryLock tryLock2 = new TryLock(2);
        Thread t1 = new Thread(tryLock1);
        Thread t2 = new Thread(tryLock2);
        t1.start();
        t2.start();
    }
}

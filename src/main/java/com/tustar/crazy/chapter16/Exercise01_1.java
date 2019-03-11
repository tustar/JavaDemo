package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/10/16.
 */

public class Exercise01_1 {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 52; i++) {
                    System.out.print(i);
                    if (i % 2 == 0) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                for (char i = 'A'; i <= 'Z'; i++) {
                    System.out.print(i);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

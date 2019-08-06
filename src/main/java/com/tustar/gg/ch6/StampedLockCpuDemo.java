package com.tustar.gg.ch6;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockCpuDemo {
    static Thread[] holdCpuThreads = new Thread[3];
    static final StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            long readLong = lock.writeLock();
            LockSupport.parkNanos(60_000_000_000L);
            lock.unlockWrite(readLong);
        }).start();
        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCpuReadThread());
            holdCpuThreads[i].start();
        }
        Thread.sleep(10_000L);
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }

    private static class HoldCpuReadThread implements Runnable {

        @Override
        public void run() {
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName() + "获得锁");
            lock.unlockRead(lockr);
        }
    }
 }

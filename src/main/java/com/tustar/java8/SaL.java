package com.tustar.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

/**
 * Created by tustar on 17-3-31.
 */
public class SaL {


    public static void main(String[] args) {
//        new Demo().run();
//        new ReentrantLockDemo().run();
//        new ReentrantReadWriteLockDemo().run();
//        new StampedLockDemo().run();
//        new OptimisticStampedLockDemo().run();
//        new ConvertStampedLockDemo().run();
        new SemaphoresDemo().run();
    }
}



class Demo extends Base {

    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

//    synchronized void incrementSync() {
//        count++;
//    }

//    void incrementSync() {
//        synchronized (this) {
//            count++;
//        }
//    }

//    public void run() {
//        IntStream.range(0, 10_000).forEach(i -> executor.submit(this::increment));
//        stop(executor);
//        System.out.println(count);
//    }

    @Override
    public void run() {
        IntStream.range(0, 10_000).forEach(i -> executor.submit(this::increment));
        stop(executor);
        System.out.println(count);
    }
}

class ReentrantLockDemo extends Base {

    ReentrantLock lock = new ReentrantLock();

    @Override
    protected void run() {
        executor.submit(() -> {
            lock.lock();
            try {
                sleep(1);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        stop(executor);
    }
}

class ReentrantReadWriteLockDemo extends Base {

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Map<String, String> map = new HashMap<>();

    Runnable readTask = () -> {
        lock.readLock().lock();
        try {
            System.out.println(map.get("foo"));
            sleep(1);
        } finally {
            lock.readLock().unlock();
        }
    };

    @Override
    protected void run() {
        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                sleep(1);
                map.put("foo", "bar");
            } finally {
                lock.writeLock().unlock();
            }
        });

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }
}

class StampedLockDemo extends Base {

    StampedLock lock = new StampedLock();
    Map<String, String> map = new HashMap<>();

    Runnable readTask = () -> {
        long stamp = lock.readLock();
        try {
            System.out.println(map.get("foo"));
            sleep(1);
        } finally {
            lock.unlockRead(stamp);
        }
    };

    @Override
    protected void run() {
        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }
}

class OptimisticStampedLockDemo extends Base {

    StampedLock lock = new StampedLock();

    @Override
    protected void run() {
        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } finally {
                lock.unlockRead(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                sleep(2);
            } finally {
                lock.unlockWrite(stamp);
                System.out.println("Write done");
            }
        });

        stop(executor);
    }
}

class ConvertStampedLockDemo extends Base {

    StampedLock lock = new StampedLock();
    int count = 0;

    @Override
    protected void run() {
        executor.submit(() -> {
            long stamp = lock.readLock();
            try {
                if (count == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if (stamp == 0L) {
                        System.out.println("Could not convert to write lock");
                        stamp = lock.writeLock();
                    }
                    count = 23;
                }
                System.out.println(count);
            } finally {
                lock.unlock(stamp);
            }
        });

        stop(executor);
    }
}

class SemaphoresDemo extends Base {

    ExecutorService executor = Executors.newFixedThreadPool(10);
    Semaphore semaphore = new Semaphore(5);

    @Override
    protected void run() {

        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    sleep(5);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (permit) {
                  semaphore.release();
                }
            }
        };

        IntStream.range(0, 10).forEach(i -> executor.submit(longRunningTask));

        stop(executor);
    }
}


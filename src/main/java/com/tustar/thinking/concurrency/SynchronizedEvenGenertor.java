package com.tustar.thinking.concurrency;

/**
 * Created by tustar on 17-5-4.
 */
public class SynchronizedEvenGenertor extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenertor());
    }
}

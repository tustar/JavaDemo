package com.tustar.broadview.concurrent.ch4;

import java.util.concurrent.atomic.AtomicLong;

public class Atomic {

    private static AtomicLong atomicLong = new AtomicLong();
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = createThread(arrayOne);
        Thread threadTwo = createThread(arrayTwo);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count 0:" + atomicLong.get());
    }

    private static Thread createThread(Integer[] arrayTwo) {
        return new Thread(() -> {
            int size = arrayTwo.length;
            for (int i = 0; i < size; i++) {
                if (arrayTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
    }
}

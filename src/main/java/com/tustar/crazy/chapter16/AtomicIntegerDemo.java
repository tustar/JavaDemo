package com.tustar.crazy.chapter16;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tustar on 16-7-18.
 */
public class AtomicIntegerDemo {

    private static AtomicInteger mUniqueToken = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getNextToken());
        }
    }

    public static final int getNextToken() {
        return mUniqueToken.getAndIncrement();
    }
}

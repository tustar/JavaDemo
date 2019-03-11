package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/6/16.
 */
public class YieldTest extends Thread {

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yieldTest1 = new YieldTest("高级");
        yieldTest1.setPriority(Thread.MAX_PRIORITY);
        yieldTest1.start();
        YieldTest yieldTest2 = new YieldTest("低级");
        yieldTest2.setPriority(Thread.MIN_PRIORITY);
        yieldTest2.start();
    }
}

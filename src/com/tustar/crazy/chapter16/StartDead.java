package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/6/16.
 */
public class StartDead extends Thread {

    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        StartDead sd = new StartDead();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                sd.start();
                System.out.println(sd.isAlive());
            }

            if (i > 20 && !sd.isAlive()) {
                sd.start();
            }
        }
    }
}

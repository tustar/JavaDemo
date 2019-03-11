package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/6/16.
 */
public class DaemanThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemanThread daemanThread = new DaemanThread();
        daemanThread.setDaemon(true);
        daemanThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

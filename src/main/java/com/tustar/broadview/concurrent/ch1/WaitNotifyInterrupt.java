package com.tustar.broadview.concurrent.ch1;

public class WaitNotifyInterrupt {

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            try {
                System.out.println("---begin---");
                synchronized (lock) {
                    lock.wait();
                }
                System.out.println("---end---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();

        Thread.sleep(1000L);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }
}

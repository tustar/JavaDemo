package com.tustar.broadview.concurrent.ch1;

public class WaitRelease {
    private static volatile Object lockA = new Object();
    private static volatile Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            try {
                synchronized (lockA) {
                    System.out.println("threadA get lockA");
                    synchronized (lockB) {
                        System.out.println("threadA get lockB");

                        //
                        System.out.println("threadA release lockA");
                        lockA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000L);
                synchronized (lockA) {
                    System.out.println("threadB get lockA");

                    System.out.println("threadB try get lockB...");
                    synchronized (lockB) {
                        System.out.println("threadB get lockB");

                        //
                        System.out.println("threadB release lockA");
                        lockA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}

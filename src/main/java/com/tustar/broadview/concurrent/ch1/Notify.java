package com.tustar.broadview.concurrent.ch1;

public class Notify {

    private static volatile Object lockA = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("threadA get lockA");
                try {
                    System.out.println("threadA begin wait");
                    lockA.wait();
                    System.out.println("threadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread threadB = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("threadB get lockA");
                try {
                    System.out.println("threadB begin wait");
                    lockA.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("threadC begin notify");
                lockA.notifyAll();
            }
        });

        threadA.start();
        threadB.start();

//        Thread.sleep(1000L);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}

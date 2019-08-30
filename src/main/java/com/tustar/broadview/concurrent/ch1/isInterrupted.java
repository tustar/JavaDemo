package com.tustar.broadview.concurrent.ch1;

public class isInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            for (;;) {

            }
        });

        threadOne.start();
        threadOne.interrupt();


        System.out.println("Thread One isInterrupted: " + threadOne.isInterrupted());
//        System.out.println("Get threadOne interrupted flag & reset " + threadOne.interrupt());

        //
        System.out.println("Main Thread interrupted: " + Thread.interrupted());
        System.out.println("Thread One isInterrupted: " + threadOne.isInterrupted());
    }
}

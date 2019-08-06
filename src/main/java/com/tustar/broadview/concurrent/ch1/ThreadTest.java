package com.tustar.broadview.concurrent.ch1;

public class ThreadTest {

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();
    }
}

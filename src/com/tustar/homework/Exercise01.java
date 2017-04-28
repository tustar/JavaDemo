package com.tustar.homework;

/**
 * Created by tustar on 17-4-28.
 */
public class Exercise01 {

    public static Object obj = new Object();

    public static void main(String[] args) {
        new MyThread("A", 0).start();
        new MyThread("B", 1).start();
    }
}

class MyThread extends Thread {

    int start;

    MyThread(String name, int start) {
        setName("线程" + name);
        this.start = start;
    }

    @Override
    public void run() {
        synchronized (Exercise01.obj) {
            for (int i = start; i < 10; i = i + 2) {
                Exercise01.obj.notify();
                System.out.println(getName() + ": " + (i * 3 + 1));
                System.out.println(getName() + ": " + (i * 3 + 2));
                System.out.println(getName() + ": " + (i * 3 + 3));
                try {
                    Exercise01.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

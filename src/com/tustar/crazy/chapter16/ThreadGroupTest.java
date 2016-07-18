package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/10/16.
 */

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " 线程的i变量" + i);
        }
    }
}

public class ThreadGroupTest {

    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字: " + mainGroup.getName());
        System.out.println("主线程组是否是后台线程组: " + mainGroup.isDaemon());
        new MyThread("主线程组的线程").start();

        ThreadGroup threadGroup = new ThreadGroup("新线程组");
        threadGroup.setDaemon(true);
        System.out.println("新线程组是否是后台线程组: " + threadGroup.isDaemon());
        new MyThread("新线程组的线程甲").start();
        new MyThread("新线程组的线程乙").start();
    }
}

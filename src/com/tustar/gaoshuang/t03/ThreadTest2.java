package com.tustar.gaoshuang.t03;

/**
 * Created by tustar on 6/23/16.
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExecute(business, "sub");
            }
        }).start();

        threadExecute(business, "main");
    }

    private static void threadExecute(Business business, String threadType) {
        for (int i = 0; i < 100; i++) {
            if ("main".equals(threadType)) {
                business.main(i);
            } else {
                business.sub(i);
            }
        }
    }
}

class Business {
    private boolean bool;

    public synchronized void main(int loop) {
        while (bool) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread seq of " + i + ", loop of " + loop);
        }
        bool = true;
        notify();
    }

    public synchronized void sub(int loop) {
        while (!bool) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("sub thread seq of " + i + ", loop of " + loop);
        }
    }
}

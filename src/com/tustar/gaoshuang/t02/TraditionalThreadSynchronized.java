package com.tustar.gaoshuang.t02;

/**
 * Created by tustar on 6/23/16.
 */
public class TraditionalThreadSynchronized {
    public static void main(String[] args) {
        final Outputter outputter = new Outputter();
        new Thread() {
            @Override
            public void run() {
                outputter.output("zhangsan");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                outputter.output("lisi");
            }
        }.start();
    }
}

class Outputter {
//    public void output(String name) {
//        synchronized (this) {
//            for (int i = 0; i < name.length(); i++) {
//                System.out.print(name.charAt(i));
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public synchronized void output(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

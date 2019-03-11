package com.tustar.lbw;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by tustar on 17-5-3.
 */
public class ThreadFactoryTest {

    static class MyThreadFactory implements ThreadFactory {

        private int counter;
        private String name;
        private List<String> stats;

        public MyThreadFactory(String name) {
            counter = 0;
            this.name = name;
            stats = new ArrayList<>();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, name + "-Thread-" + counter);
            counter++;
            stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
            return t;
        }

        public String getStats() {
            StringBuffer buffer = new StringBuffer();
            Iterator<String> iterator = stats.iterator();
            while (iterator.hasNext()) {
                buffer.append(iterator.next());
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }

    static class MyTask implements Runnable {

        private int num;

        public MyTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("Task " + num + " is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("main thread begin");
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Thread thread = null;
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(new MyTask(i));
            thread.start();
        }
        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n", factory.getStats());
        System.out.println("main thread end");
    }
}

package com.tustar.lbw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tustar on 17-5-3.
 */
public class ThreadLocalTest {

    //创建一个Integer型的线程本地变量
    static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    static class Task implements Runnable {

        private int num;

        public Task(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            //获取当前线程的本地变量，然后累加10次
            Integer i = local.get();
            while (++i < 10) {
                System.out.println("Task " +  num + " local num result is " + i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("main thread start");
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();
        System.out.println("main thread end");
    }
}

package com.tustar.lbw;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by tustar on 17-5-2.
 */
public class FutrueTaskTest2 {

    public static void main(String[] args) {
        System.out.println("main thread begin at:" + System.nanoTime());
        ExecutorService executor = Executors.newCachedThreadPool();
        MyTask task1 = new MyTask("1");
        MyTask task2 = new MyTask("2");
        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);
        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("task1的运行结果:" + result1.get());
            System.out.println("task2的运行结果:" + result2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main thread finish at:" + System.nanoTime());
    }
}

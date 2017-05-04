package com.tustar.lbw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 功能概要：缓冲线程池实例-submit运行
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     *
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用，干活！！！  " + Thread.currentThread().getName());
        // 一个模拟耗时的操作
        for (int i = 0; i < 1_000_000; i++) {

        }
        return "call()方法被自动调用，任务的将结果是：" + id + "  " + Thread.currentThread().getName();
    }
}

public class ThreadPool2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();
        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executor.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }
        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        executor.shutdown();
        //遍历任务的结果  
        for (Future<String> feture : resultList) {
            try {
                System.out.println(feture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}


package com.tustar.lbw;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-5-2.
 */
public class MyThreadPoolTest {

    private static int produceTaskSleepTime = 2;
    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {
        // 构造一个线程池
        ThreadPoolExecutor threadPool  = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < produceTaskMaxNumber; i++) {
            try {
                // 产生一个任务，并将其加入到线程池
                String task = "task@ " + i;
                System.out.println("put " + task);
                threadPool.execute(new ThreadPoolTask(task));
                // 便于观察，等待一段时间
                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 线程池执行的任务
 */
class ThreadPoolTask implements Runnable, Serializable {

    private static final long serialVersionUID = 0;
    private static int comsumeTaskSleepTime = 2000;
    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    @Override
    public void run() {
        // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
        System.out.println(Thread.currentThread().getName());
        System.out.println("start..." + threadPoolTaskData);
        try {
            Thread.sleep(comsumeTaskSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolTaskData = null;
    }

    public Object getTask() {
        return threadPoolTaskData;
    }
}

package com.tustar.lbw;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by tustar on 17-5-2.
 */
public class ThradPool1 {

    public static void main(String[] args) {
//        testCachedThreadPool();
//        testFixedThreadPool();
//        testSingleThreadPool();
//        testScheduledThreadPool();
//        executeFixedRate();
//        executeFixedDelay();
        executeEightAtNightPerDay("14:56:30");
    }

    private static void testCachedThreadPool() {
        System.out.println("Main: Starting at: " + new Date());
        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Handler(String.valueOf(i)));
        }
        //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        executor.shutdown();
        System.out.println("Main: Finished all threads at: " + new Date());
    }

    private static void testFixedThreadPool() {
        System.out.println("Main: Starting at: " + new Date());
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Handler(String.valueOf(i)));
        }
        //执行到此处并不会马上关闭线程池
        executor.shutdown();
        System.out.println("Main: Finished all threads at: " + new Date());
    }

    private static void testSingleThreadPool() {
        System.out.println("Main: Starting at: " + new Date());
        //创建大小为1的固定线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Handler(String.valueOf(i)));
        }
        //执行到此处并不会马上关闭线程池
        executor.shutdown();
        System.out.println("Main: Finished all threads at: " + new Date());
    }

    private static void testScheduledThreadPool() {
        System.out.println("Main: Starting at: " + new Date());
        //创建大小为10的线程池
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            //延迟10秒执行
            executor.schedule(new Handler(String.valueOf(i)), 10, TimeUnit.SECONDS);
        }
        //执行到此处并不会马上关闭线程池
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Main: Finished all threads at: " + new Date());
    }

    /**
     * 初始化延迟0ms开始执行，每隔2000ms重新执行一次任务
     */
    private static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleAtFixedRate(new Handler("1"), 0, 2000, TimeUnit.MILLISECONDS);
    }

    /**
     * 以固定延迟时间进行执行
     * 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务
     */
    private static void executeFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleWithFixedDelay(new Handler("1"), 0, 2000, TimeUnit.MILLISECONDS);
    }

    /**
     * 每天晚上9点执行一次
     * 每天定时安排任务进行执行
     */
    private static void executeEightAtNightPerDay(String time) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = getTimeMillis(time) - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        executor.scheduleAtFixedRate(new Handler("1"), initDelay, oneDay, TimeUnit.MILLISECONDS);

    }

    /**
     * 获取指定时间对应的毫秒数 "HH:mm:ss"
     *
     * @param time
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

class Handler implements Runnable {

    private String name;

    public Handler(String name) {
        this.name = "Thread" + name;
    }


    @Override
    public void run() {
        System.out.println(name + " Start.Time = " + new Date());
        processCommand();
        System.out.println(name + " End.Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

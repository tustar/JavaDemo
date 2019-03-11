package com.tustar.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tustar on 17-4-28.
 */
public class SettingDefaultHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new ExceptionThread2());
    }
}

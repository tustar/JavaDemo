package com.tustar.java8;

import com.tustar.utils.ConcurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-4-1.
 */
public abstract class Base {

    protected ExecutorService executor = Executors.newFixedThreadPool(2);

    protected abstract void run();

    protected void stop(ExecutorService executor) {
        ConcurrentUtils.stop(executor);
    }

    protected void sleep(long timeout) {
        ConcurrentUtils.sleep(timeout);
    }
}

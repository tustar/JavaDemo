package com.tustar.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-4-1.
 */
public class ConcurrentUtils {

    public static void stop(ExecutorService executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

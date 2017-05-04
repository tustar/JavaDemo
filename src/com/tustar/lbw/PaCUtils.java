package com.tustar.lbw;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tustar on 17-5-3.
 */
public class PaCUtils {

    public static void doPaC(AStorehouse storehouse) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(500);
            if (value % 2 == 0) {
                Producer producer = new Producer(storehouse, value);
                executor.execute(producer);
            } else {
                Consumer consumer = new Consumer(storehouse, value);
                executor.execute(consumer);
            }
        }
        executor.shutdown();
    }
}

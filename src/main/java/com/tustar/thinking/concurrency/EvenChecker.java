package com.tustar.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tustar on 17-5-4.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executor.execute(new EvenChecker(gp, i));
        }
        executor.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}

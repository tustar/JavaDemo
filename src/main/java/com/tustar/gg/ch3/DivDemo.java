package com.tustar.gg.ch3;

import java.util.concurrent.*;

public class DivDemo {

    public static class DivTask implements Runnable {

        int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a / b;
            System.out.println(re);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
//           Future re = executor.submit(new DivTask(100, i));
//           re.get();
            executor.execute(new DivTask(100, i));
        }
    }
}

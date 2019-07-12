package com.tustar.gg.ch3;

import java.util.concurrent.*;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int corePoolSize,
                                   int maximumPoolSize,
                                   long keepAliveTime,
                                   TimeUnit unit,
                                   BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                Executors.defaultThreadFactory());
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientName) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                clientStack.printStackTrace();
                throw e;
            }
        };
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            executor.execute(new DivDemo.DivTask(100, i));
        }
    }
}

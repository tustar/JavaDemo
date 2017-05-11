package com.tustar.java8;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-3-22.
 */
public class TaE {
    public static void main(String[] args) {
//        Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("TaE " + threadName);
//        };
//
//        task.run();
//
//        Thread thread = new Thread(task);
//        thread.start();
//
//        System.out.println();

//        Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Foo " + threadName);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Bar " + threadName);
//        };
//
//        Thread thread = new Thread(task);
//        thread.start();

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("TaE " + threadName);
//        });
//
//        System.out.println("attempt to shutdown executor");
//        executor.shutdown();
//        try {
//            executor.awaitTermination(5, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            System.err.println("tasks interrupted");
//        } finally {
//            if (!executor.isTerminated()) {
//                System.err.println("cancel non-finished tasks");
//            }
//            executor.shutdownNow();
//            System.out.println("shutdown finished");
//        }

//        Callable<Integer> task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                return 123;
//            } catch (InterruptedException e) {
//                throw new IllegalArgumentException("task interrupted", e);
//            }
//
//        };
//
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executor.submit(task);
//        System.out.println("future done? " + future.isDone());
//        try {
//            Integer result = future.get();
//            System.out.println("future done? " + future.isDone());
//            System.out.println("result: " + result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        executor.shutdownNow();
//        try {
//            future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executor.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                return 123;
//            } catch (InterruptedException e) {
//                throw new IllegalStateException("task interrupted", e);
//            }
//        });
//
//        try {
//            future.get(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

//        ExecutorService executor = Executors.newWorkStealingPool();
//        List<Callable<String>> callables = Arrays.asList(
//                () -> "task1",
//                () -> "task2",
//                () -> "task3"
//        );
//        try {
//            executor.invokeAll(callables)
//                    .stream()
//                    .map(future -> {
//                        try {
//                            return future.get();
//                        } catch (Exception e) {
//                            throw new IllegalStateException(e);
//                        }
//                    })
//                    .forEach(System.out::println);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        ExecutorService executor = Executors.newWorkStealingPool();
//        List<Callable<String>> callables = Arrays.asList(
//                callable("task1", 2),
//                callable("task2", 1),
//                callable("task3", 3)
//        );
//        String result = null;
//        try {
//            result = executor.invokeAny(callables);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
//        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
//        try {
//            TimeUnit.MILLISECONDS.sleep(1337);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
//        System.out.printf("Remaining Delay: %sms", remainingDelay);
//        System.out.println();

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
//        int initialDelay = 0;
//        int period = 1;
//        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };
        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

    }

    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}

package com.tustar.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-5-8.
 */
class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    private Random random = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {

        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {

        private ExecutorService executor;

        public EndSentinel(ExecutorService executor) {
            super(-1);
            this.executor = executor;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask task : sequence) {
                System.out.println(task.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            executor.shutdownNow();
        }
    }
}

class PrioritizedTaskProducer implements Runnable {

    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService executor;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService executor) {
        this.queue = queue;
        this.executor = executor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask((10)));
            }
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(executor));
        } catch (InterruptedException e) {

        }
        System.out.println("Finished PrioritizedTaskProducer");
    }
}

class PrioritiedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> queue;

    public PrioritiedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                queue.take().run();
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}


public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executor = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        executor.execute(new PrioritizedTaskProducer(queue, executor));
        executor.execute(new PrioritiedTaskConsumer(queue));
    }
}

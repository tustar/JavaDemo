package com.tustar.concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-5-8.
 */
public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }

        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left = left;
        this.right = right;
        id = ident;
        ponderFactor = ponder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(this + " thinking");
                pause();
                System.out.println(this + " grabbing right");
                right.take();
                System.out.println(this + " grabbing left");
                left.take();
                System.out.println(this + " eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}

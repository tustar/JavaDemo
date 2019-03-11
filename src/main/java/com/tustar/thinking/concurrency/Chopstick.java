package com.tustar.thinking.concurrency;

/**
 * Created by tustar on 17-5-8.
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }

        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}

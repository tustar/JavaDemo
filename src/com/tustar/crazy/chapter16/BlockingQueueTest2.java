package com.tustar.crazy.chapter16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tustar on 6/10/16.
 */
class Producer extends Thread {

    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String[] strArr = new String[]{
                "Java",
                "Python",
                "Ruby"
        };
        for (int i = 0; i < 999999999; i++) {
            System.out.println(getName() + "生产者准备生产集合元素！");
            try {
                Thread.sleep(200);
                blockingQueue.put(strArr[i % 3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成: " + blockingQueue);
        }
    }
}

class Consumer extends Thread {

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "消费者准备消费集合元素！");
            try {
                Thread.sleep(200);
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成: " + blockingQueue);
        }
    }
}

public class BlockingQueueTest2 {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        new Producer(blockingQueue).start();
        new Producer(blockingQueue).start();
        new Producer(blockingQueue).start();
        new Consumer(blockingQueue).start();
    }
}

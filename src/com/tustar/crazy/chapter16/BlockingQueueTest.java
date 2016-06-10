package com.tustar.crazy.chapter16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tustar on 6/10/16.
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String>  blockingQueue = new ArrayBlockingQueue<>(2);
        try {
            blockingQueue.put("Java");
            blockingQueue.put("Java");
            blockingQueue.put("Java");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

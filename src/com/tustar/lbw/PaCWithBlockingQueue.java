package com.tustar.lbw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tustar on 17-5-3.
 */
public class PaCWithBlockingQueue {
    public static void main(String[] args) {
        PaCUtils.doPaC(new StorehouseWithBlockingQueue(2000));
    }
}

class StorehouseWithBlockingQueue extends AStorehouse {

    private int capacity;
    private BlockingQueue<Object> stores;
    private AtomicInteger currentSize = new AtomicInteger(0);

    public StorehouseWithBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.stores = new ArrayBlockingQueue<>(capacity);
        System.out.println("仓库的库存上限是" + capacity);
    }

    public void produce(int num) throws InterruptedException {
        while (currentSize.get() + num > capacity) {
            System.out.println("【库存剩余空间不足，无法生产" + num + "个产品】" + "库存:" + currentSize.get());
        }
        System.out.println("【库存未满，可生产" + num + "个产品】" + "库存:" + currentSize.get());
        for (int i = 0; i < num; i++) {
            stores.put(new Object());
            currentSize.incrementAndGet();
        }
        System.out.println("【已生产" + num + "个产品】" + "库存:" + currentSize.get());
    }

    public void consume(int num) throws InterruptedException {
        while (currentSize.get() < num) {
            System.out.println("【库存不足，无法消费" + num + "个产品】" + "库存:" + currentSize.get());
        }
        System.out.println("【库存充足，可消费" + num + "个产品】" + "库存:" + currentSize.get());
        for (int i = 0; i < num; i++) {
            stores.take();
            currentSize.decrementAndGet();
        }
        System.out.println("【已消费" + num + "个产品】" + "库存:" + currentSize.get());
    }
}

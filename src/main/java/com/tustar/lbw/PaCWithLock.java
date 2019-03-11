package com.tustar.lbw;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tustar on 17-5-3.
 */
public class PaCWithLock {
    public static void main(String[] args) {
        PaCUtils.doPaC(new StorehouseWithLock(1500));
    }
}

class StorehouseWithLock extends AStorehouse {

    private int capacity;
    private List<Object> stores = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public StorehouseWithLock(int capacity) {
        this.capacity = capacity;
        System.out.println("仓库的库存上限是" + capacity);
    }

    public void produce(int num) throws InterruptedException {
        lock.lock();
        try {

            while (stores.size() + num > capacity) {
                System.out.println("【库存剩余空间不足，无法生产" + num + "个产品】" + "库存:" + stores.size());
                empty.await();
            }
            System.out.println("【库存未满，可生产" + num + "个产品】" + "库存:" + stores.size());
            for (int i = 0; i < num; i++) {
                stores.add(new Object());
            }
            System.out.println("【已生产" + num + "个产品】" + "库存:" + stores.size());
            full.signalAll();
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int num) throws InterruptedException {
        lock.lock();
        try {
            while (stores.size() < num) {
                System.out.println("【库存不足，无法消费" + num + "个产品】" + "库存:" + stores.size());
                full.await();
            }
            System.out.println("【库存充足，可消费" + num + "个产品】" + "库存:" + stores.size());
            for (int i = 0; i < num; i++) {
                stores.remove(0);
            }
            System.out.println("【已消费" + num + "个产品】" + "库存:" + stores.size());
            empty.signalAll();
            full.signalAll();
        } finally {
            lock.unlock();
        }
    }
}



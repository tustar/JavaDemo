package com.tustar.lbw;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tustar on 17-5-3.
 */
public class PaCWithWN {
    public static void main(String[] args) {
        PaCUtils.doPaC(new StorehouseWithWN(1000));
    }
}

class StorehouseWithWN extends AStorehouse {

    private int capacity;
    private List<Object> stores = new LinkedList<>();

    public StorehouseWithWN(int capacity) {
        this.capacity = capacity;
        System.out.println("仓库的库存上限是" + capacity);
    }

    public void produce(int num) throws InterruptedException {
        synchronized (stores) {
            while (stores.size() + num > capacity) {
                System.out.println("【库存剩余空间不足，无法生产" + num + "个产品】" + "库存:" + stores.size());
                stores.wait();
            }
            System.out.println("【库存未满，可生产" + num + "个产品】" + "库存:" + stores.size());
            for (int i = 0; i < num; i++) {
                stores.add(new Object());
            }
            System.out.println("【已生产" + num + "个产品】" + "库存:" + stores.size());
            stores.notifyAll();
        }
    }

    public void consume(int num) throws InterruptedException {
        synchronized (stores) {
            while (stores.size() < num) {
                System.out.println("【库存不足，无法消费" + num + "个产品】" + "库存:" + stores.size());
                stores.wait();
            }
            System.out.println("【库存充足，可消费" + num + "个产品】" + "库存:" + stores.size());
            for (int i = 0; i < num; i++) {
                stores.remove(0);
            }
            System.out.println("【已消费" + num + "个产品】" + "库存:" + stores.size());
            stores.notifyAll();
        }
    }
}


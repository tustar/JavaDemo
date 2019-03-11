package com.tustar.lbw;

/**
 * Created by tustar on 17-5-3.
 */
class Consumer implements Runnable {

    private AStorehouse storehouse;
    private int num;

    public Consumer(AStorehouse storehouse, int num) {
        this.storehouse = storehouse;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            storehouse.consume(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

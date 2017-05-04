package com.tustar.lbw;

/**
 * Created by tustar on 17-5-3.
 */
class Producer implements Runnable {

    private AStorehouse storehouse;
    private int num;

    public Producer(AStorehouse storehouse, int num) {
        this.storehouse = storehouse;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            storehouse.produce(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

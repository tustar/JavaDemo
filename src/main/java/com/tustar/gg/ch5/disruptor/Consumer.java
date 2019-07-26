package com.tustar.gg.ch5.disruptor;

import com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData event) {
        System.out.println(Thread.currentThread().getName() + ":Event:--"
                + event.get() + "--");
    }
}

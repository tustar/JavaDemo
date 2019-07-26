package com.tustar.gg.ch5.disruptor;

import com.lmax.disruptor.EventFactory;

public class PCDataFactory implements EventFactory<PCData> {

    @Override
    public PCData newInstance() {
        return new PCData();
    }
}

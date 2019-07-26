package com.tustar.gg.ch5.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.sun.xml.internal.bind.v2.runtime.output.Pcdata;

import java.nio.ByteBuffer;

public class Producer {

    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb) {
        long sequence = ringBuffer.next();
        try {
            PCData event = ringBuffer.get(sequence);
            event.set(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

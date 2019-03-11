package com.tustar.lbw;

/**
 * Created by tustar on 17-5-3.
 */
abstract class AStorehouse {
    public abstract void produce(int num) throws InterruptedException;

    public abstract void consume(int num) throws InterruptedException;
}

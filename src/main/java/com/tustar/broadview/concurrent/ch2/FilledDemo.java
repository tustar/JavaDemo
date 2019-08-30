package com.tustar.broadview.concurrent.ch2;

import sun.misc.Contended;

public class FilledDemo {

    public final static class FilledLong1 {
        public volatile long value = 0L;
        public long p1, p2, p3, p4, p5, p6;
    }

    @Contended
    public final static class FilledLong2 {
        public volatile long value = 0L;
    }

    @Contended("tlr")
    long threadLocalRandomSeed;

    @Contended("tlr")
    int threadLocalRandomProbe;

    @Contended("tlr")
    int getThreadLocalRandomSecondarySeed;

}

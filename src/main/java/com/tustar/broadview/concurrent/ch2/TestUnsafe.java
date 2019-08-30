package com.tustar.broadview.concurrent.ch2;

import sun.misc.Unsafe;

public class TestUnsafe {

    static final Unsafe unsafe = Unsafe.getUnsafe();
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafe testUnsafe = new TestUnsafe();
        Boolean success = unsafe.compareAndSwapInt(testUnsafe, stateOffset, 0, 1);
        System.out.println(success);
    }
}

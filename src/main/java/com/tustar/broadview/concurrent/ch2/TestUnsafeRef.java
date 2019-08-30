package com.tustar.broadview.concurrent.ch2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafeRef {

    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnsafeRef.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafeRef testUnsafe = new TestUnsafeRef();
        Boolean success = unsafe.compareAndSwapInt(testUnsafe, stateOffset, 0, 1);
        System.out.println(success);
    }
}

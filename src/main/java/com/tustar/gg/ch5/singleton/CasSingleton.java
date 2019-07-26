package com.tustar.gg.ch5.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS实现(线程安全)
 */
public final class CasSingleton {
    private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<>();

    private CasSingleton() {

    }

    public static CasSingleton getInstance() {
        for (; ; ) {
            CasSingleton current = INSTANCE.get();
            if (current != null) {
                return current;
            }

            current = new CasSingleton();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }
}

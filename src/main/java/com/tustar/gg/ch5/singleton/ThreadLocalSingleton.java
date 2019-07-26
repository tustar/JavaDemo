package com.tustar.gg.ch5.singleton;

/**
 * ThreadLocal(线程安全)
 */
public final class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> SINGLETON = ThreadLocal.withInitial(() -> new ThreadLocalSingleton());

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return SINGLETON.get();
    }
}

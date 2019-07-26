package com.tustar.gg.ch5.singleton;

/**
 * 懒汉式(线程不安全,并发场景不可用)
 */
public final class UnsafeLazySingleton {

    private static UnsafeLazySingleton sInstance;

    private UnsafeLazySingleton() {
    }

    public static UnsafeLazySingleton getsInstance() {
        if (sInstance == null) {
            sInstance = new UnsafeLazySingleton();
        }

        return sInstance;
    }
}

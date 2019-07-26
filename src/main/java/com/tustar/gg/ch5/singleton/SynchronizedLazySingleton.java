package com.tustar.gg.ch5.singleton;

/**
 * 同步的懒汉式(线程安全,可用,不建议使用)
 */
public final class SynchronizedLazySingleton {

    private static SynchronizedLazySingleton sInstance;

    private SynchronizedLazySingleton() {
        System.out.println("UnsafeLazySingleton is create");
    }

    public static synchronized SynchronizedLazySingleton getsInstance() {
        if (sInstance == null) {
            sInstance = new SynchronizedLazySingleton();
        }

        return sInstance;
    }
}

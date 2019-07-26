package com.tustar.gg.ch5.singleton;

/**
 * 双重检查锁DCL(线程安全,大多数场景满足需求,推荐使用)
 */
public final class DCLSingleton {

    private static volatile DCLSingleton sInstance;

    private DCLSingleton() {

    }

    public static DCLSingleton getInstance() {
        if (sInstance == null) {
            synchronized (DCLSingleton.class) {
                if (sInstance == null) {
                    sInstance = new DCLSingleton();
                }
            }
        }

        return sInstance;
    }
}

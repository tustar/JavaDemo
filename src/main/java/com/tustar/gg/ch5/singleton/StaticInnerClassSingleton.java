package com.tustar.gg.ch5.singleton;

/**
 * 静态内部内(线程安全,推荐使用)
 */
public final class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {

    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

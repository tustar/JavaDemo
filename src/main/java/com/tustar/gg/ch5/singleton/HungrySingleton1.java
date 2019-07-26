package com.tustar.gg.ch5.singleton;

/**
 * 饿汉式(静态常量, 线程安全, 可用)
 */
public final class HungrySingleton1 {

    private static HungrySingleton1 sInstance = new HungrySingleton1();

    private HungrySingleton1() {

    }

    public static HungrySingleton1 getInstance() {
        return sInstance;
    }
}

package com.tustar.gg.ch5.singleton;

/**
 * 饿汉式(静态常量, 线程安全, 可用)
 */
public final class HungrySingleton2 {

    public static final HungrySingleton2 INSTANCE = new HungrySingleton2();

    private HungrySingleton2() {

    }
}

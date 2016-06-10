package com.tustar.crazy.chapter16;

/**
 * Created by tustar on 6/10/16.
 */
class MyExHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常: " + e);
    }
}

public class ExHandler {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        int a = 5 / 0;
        System.out.println("程序正常结束！");
    }
}

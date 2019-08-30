package com.tustar.broadview.concurrent.ch6;

import java.util.concurrent.locks.LockSupport;

public class TestUnPark {
    public static void main(String[] args) {
        System.out.println("begin park!");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");
    }
}

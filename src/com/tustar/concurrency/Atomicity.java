package com.tustar.concurrency;

/**
 * Created by tustar on 17-5-4.
 */
public class Atomicity {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}

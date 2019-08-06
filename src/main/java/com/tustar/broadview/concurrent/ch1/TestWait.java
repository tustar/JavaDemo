package com.tustar.broadview.concurrent.ch1;

public class TestWait {

    public static void main(String[] args) {
        Object object = new Object();
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

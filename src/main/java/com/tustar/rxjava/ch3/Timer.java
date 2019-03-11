package com.tustar.rxjava.ch3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long s) throws Exception {
                        System.out.println("onNext :: " + "Hello Timer");
                    }
                });

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

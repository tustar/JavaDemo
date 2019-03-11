package com.tustar.rxjava.ch3;


import io.reactivex.Observable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class RepeatUtil {
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(5)
                .repeatUntil(new BooleanSupplier() {
                    @Override
                    public boolean getAsBoolean() throws Exception {
                        return System.currentTimeMillis() - start > 5000L;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long s) throws Exception {
                        System.out.println("onNext :: " + s);
                    }
                });

        try{
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

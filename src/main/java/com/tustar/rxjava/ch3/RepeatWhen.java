package com.tustar.rxjava.ch3;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

public class RepeatWhen {
    public static void main(String[] args) {
        Observable.range(0, 9)
                .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                        return Observable.timer(10, TimeUnit.SECONDS);
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext :: " + integer);
                    }
                });

        try {
            Thread.sleep(12000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

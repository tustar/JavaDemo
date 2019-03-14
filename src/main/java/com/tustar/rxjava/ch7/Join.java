package com.tustar.rxjava.ch7;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) {
        Observable odds = Observable.just(1, 2, 3).delay(200, TimeUnit.MILLISECONDS);
        Observable evens = Observable.just(4, 5, 6);

        odds.join(evens, new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                return Observable.just(String.valueOf(integer))
                        .delay(200, TimeUnit.MILLISECONDS);
            }
        }, new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                return Observable.just(String.valueOf(integer))
                        .delay(200, TimeUnit.MILLISECONDS);
            }
        }, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer integer, Integer integer2) {
                return integer + ":" + integer2;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("onNext :: " + s);
            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

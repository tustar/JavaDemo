package com.tustar.rxjava.ch6;


import io.reactivex.Observable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;

public class SequenceEqual {
    public static void main(String[] args) {
        Observable.sequenceEqual(
                Observable.just(1, 2, 3, 4, 5),
                Observable.just(1, 2, 3, 4, 5)
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("onSuccess :: " + aBoolean);
            }
        });

        System.out.println("--------------------------");

        Observable.sequenceEqual(
                Observable.just(1, 2, 3, 4, 5),
                Observable.just(1, 2, 3, 4, 5, 6)
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("onSuccess :: " + aBoolean);
            }
        });

        System.out.println("--------------------------");

        Observable.sequenceEqual(
                Observable.just(1, 2, 3, 4, 5),
                Observable.just(2, 3, 4, 5, 6),
                new BiPredicate<Integer, Integer>() {
                    @Override
                    public boolean test(Integer integer, Integer integer2) throws Exception {
                        return integer + 1 == integer2;
                    }
                }
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("onSuccess :: " + aBoolean);
            }
        });
    }
}

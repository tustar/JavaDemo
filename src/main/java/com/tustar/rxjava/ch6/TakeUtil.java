package com.tustar.rxjava.ch6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class TakeUtil {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .takeUntil(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer == 5;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("onNext :: " + integer);
            }
        });
    }
}

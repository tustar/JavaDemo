package com.tustar.rxjava.ch6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class All {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 10;
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        System.out.println("onSuccess :: " + aBoolean);
                    }
                });
        System.out.println("--------------------------");

        Observable.just(1, 2, 3, 4, 5)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 3;
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        System.out.println("onSuccess :: " + aBoolean);
                    }
                });
    }
}

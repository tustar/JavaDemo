package com.tustar.rxjava.ch6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class DefaultIfEmpty {
    public static void main(String[] args) {
        Observable.empty()
                .defaultIfEmpty(8)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) {
                        System.out.println("onNext :: " + o);
                    }
                });

        System.out.println("--------------------------");

        Observable.empty()
                .switchIfEmpty(Observable.just(1, 2, 3))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) {
                        System.out.println("onNext :: " + o);
                    }
                });

    }
}

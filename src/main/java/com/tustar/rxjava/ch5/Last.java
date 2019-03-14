package com.tustar.rxjava.ch5;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Last {
    public static void main(String[] args) {
        Observable.just(2, 4, 1, 37)
                .last(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext :: " + integer);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError :: " + throwable.getMessage());
                    }
                });

    }
}

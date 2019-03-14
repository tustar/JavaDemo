package com.tustar.rxjava.ch6;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Contains {
    public static void main(String[] args) {
        Observable.just(2, 30, 22, 1, 3)
                .contains(2)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        System.out.println("onSuccess :: " + aBoolean);
                    }
                });
        System.out.println("--------------------------");

        Observable.just(2, 30, 22, 1, 3)
                .isEmpty()
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        System.out.println("onSuccess :: " + aBoolean);
                    }
                });
    }
}

package com.tustar.rxjava.ch3;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Repeat {
    public static void main(String[] args) {
        Observable.just("Repeat")
                .repeat(3)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept (String s) throws Exception {
                        System.out.println("onNext :: " + s);
                    }
                });
    }
}

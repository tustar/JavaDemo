package com.tustar.rxjava.ch3;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;

import java.util.concurrent.Callable;

public class Defer {

    public static void main(String[] args) {
        Observable observable = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
               return Observable.just("Defer");
            }
        });

        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("onNext :: " + s);
            }
        });
    }
}

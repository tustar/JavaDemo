package com.tustar.rxjava.ch7;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class Zip {
    public static void main(String[] args) {
        Observable odds = Observable.just(1, 3, 5);
        Observable evens = Observable.just(2, 4, 6);

        doZip(odds, evens);

        System.out.println("--------------------------");

        more();
    }

    private static void more() {
        Observable odds = Observable.just(1, 3, 5, 7, 9);
        Observable evens = Observable.just(2, 4, 6);

        doZip(odds, evens);
    }

    private static void doZip(Observable odds, Observable evens) {
        Observable.zip(odds, evens, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        })
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
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete :: ");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("onSubscribe :: " + disposable);
                    }
                });
    }
}

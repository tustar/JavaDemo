package com.tustar.rxjava.ch7;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Merge {
    public static void main(String[] args) {

        Observable odds = Observable.just(1, 3, 5);
        Observable evens = Observable.just(2, 4, 6);

        doMerge(odds, evens);

        System.out.println("--------------------------");

        more();
    }

    public static void more() {
        Observable odds = Observable.just(1, 3, 5, 9);
        Observable evens = Observable.just(2, 4, 6);

        doMerge(odds, evens);
    }

    private static void doMerge(Observable odds, Observable evens) {
        Observable.merge(odds, evens)
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

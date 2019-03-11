package com.tustar.rxjava.ch5;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Window {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .window(2)
                .subscribe(new Consumer<Observable<Integer>>() {
                               @Override
                               public void accept(Observable<Integer> integerObservable) throws Exception {
                                   System.out.println("onNext :: ");
                                   integerObservable
                                           .subscribe(new Consumer<Integer>() {
                                               @Override
                                               public void accept(Integer integer) throws Exception {
                                                   System.out.println("inner onNext :: " + integer);
                                               }
                                           });
                               }
                           }
                        , new Consumer<Throwable>() {
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

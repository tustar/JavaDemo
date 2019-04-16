package com.tustar.rxjava.ch4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;

public class Stream {
    public static void main(String[] args) {
        RxJavaPlugins.setOnObservableAssembly(new Function<Observable, Observable>() {
            @Override
            public Observable apply(Observable observable) throws Exception {
                System.out.println("setOnObservableAssembly :: apply :: " + observable);
                return observable;
            }
        });
        RxJavaPlugins.setOnObservableSubscribe(new BiFunction<Observable, Observer, Observer>() {
            @Override
            public Observer apply(Observable observable, Observer observer) throws Exception {
                System.out.println("setOnObservableSubscribe :: apply :: " + observer);
                return observer;
            }
        });

        //
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello");
            }
        });
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe :: d = " + d);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext :: s = " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError :: e = " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }
}

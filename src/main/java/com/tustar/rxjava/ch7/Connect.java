package com.tustar.rxjava.ch7;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Connect {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS).take(6);
        ConnectableObservable<Long> connectableObservable = obs.publish();

        connectableObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Subscriber1 :: onSubscribe :: " + d);
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("Subscriber1 :: onNext :: " + aLong + " -> time:" + sdf.format(new Date()));
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Subscriber1 :: onError :: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Subscriber1 :: onComplete :: ");
            }
        });

        connectableObservable.delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("Subscriber2 :: onSubscribe :: " + d);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("Subscriber2 :: onNext :: " + aLong + " -> time:" + sdf.format(new Date()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Subscriber2 :: onError :: " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Subscriber2 :: onComplete :: ");
                    }
                });

        connectableObservable.connect();

        try {
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

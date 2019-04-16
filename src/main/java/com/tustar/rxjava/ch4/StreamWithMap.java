package com.tustar.rxjava.ch4;

import io.reactivex.Observable;

public class StreamWithMap {
    public static void main(String[] args) {
        Observable.just(1)
                .map(integer -> String.valueOf(integer))
                .subscribe(s -> System.out.println("onNext :: " + s));
    }
}

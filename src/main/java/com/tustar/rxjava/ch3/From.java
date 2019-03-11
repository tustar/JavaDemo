package com.tustar.rxjava.ch3;


import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;
import java.util.List;

public class From {
    public static void main(String[] args) {
        Observable.fromArray("good", "morning").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("onNext :: " + s);
            }
        });

        System.out.println("---------------------");

        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(i);
        }
        Observable.fromIterable(items).subscribe(new Consumer<Integer>() {
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
        });
    }
}

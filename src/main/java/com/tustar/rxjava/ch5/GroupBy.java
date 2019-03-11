package com.tustar.rxjava.ch5;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class GroupBy {
    public static void main(String[] args) {
        Observable.range(1, 8)
                .groupBy(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return integer % 2 == 0 ? "odd" : "even";
                    }
                })
                .subscribe(new Consumer<GroupedObservable<String, Integer>>() {
                    @Override
                    public void accept(GroupedObservable<String, Integer> stringIntegerGroupedObservable) throws Exception {

                        if (stringIntegerGroupedObservable.getKey().equalsIgnoreCase("odd")) {
                            System.out.println("onNext :: " + stringIntegerGroupedObservable.getKey());
                            stringIntegerGroupedObservable
                                    .subscribe(new Consumer<Integer>() {
                                        @Override
                                        public void accept(Integer integer) throws Exception {
                                            System.out.println("onNext :: " + integer);
                                        }
                                    });
                        }
                    }
                });
    }
}

package com.tustar.rxjava.ch3;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class From {
    public static void main(String[] args) {

        fromArray();

        System.out.println("--------------------------");

        fromIterable();

        System.out.println("--------------------------");

        fromFuture();

        System.out.println("--------------------------");

        fromFutureWithTimeout();
    }

    private static void fromArray() {
        Observable.fromArray("good", "morning")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("onNext :: " + s);
                    }
                });
    }

    private static void fromIterable() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(i);
        }
        Observable.fromIterable(items)
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
                });
    }

    private static void fromFutureWithTimeout() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        Observable.fromFuture(future, 4, TimeUnit.SECONDS)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("onNext :: " + s);
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

    @NotNull
    private static void fromFuture() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        Observable.fromFuture(future)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("onNext :: " + s);
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

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("模拟一些耗时的任务...");
            Thread.sleep(5000L);
            return "OK";
        }
    }
}

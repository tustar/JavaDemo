package com.tustar.gg.ch6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsync {
    public static Integer calc(Integer para) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return para * para;
    }

    public static Integer calc3(Integer para) {
        return para / 0;
    }

    public static Integer calc4(Integer para) {
        return para / 2;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test5();
    }

    private static void test1() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> calc(50));
        System.out.println(future.get());
    }

    private static void test2() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> calc(50))
                .thenApply(i -> Integer.toString(i))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);
        future.get();
    }

    private static void test3() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> calc3(50))
                .exceptionally(ex -> {
                    System.out.println(ex.toString());
                    return 0;
                })
                .thenApply(i -> Integer.toString(i))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);
        future.get();
    }

    private static void test4() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> calc4(50))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> calc4(i)))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);
        future.get();
    }

    private static void test5() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> calc4(50));
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> calc4(25));

        CompletableFuture<Void> future3 = future1.thenCombine(future2, (i, j) -> (i + j))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);
        future3.get();

    }
}

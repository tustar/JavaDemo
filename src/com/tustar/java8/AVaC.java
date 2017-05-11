package com.tustar.java8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * Created by tustar on 17-4-1.
 */
public class AVaC {

    public static void main(String[] args) {
//        new IncrementAndGet().run();
//        new UpdateAndGet().run();
//        new AccumulateAndGet().run();
//        new LongAdderDemo().run();
//        new LongAccumulatorDemo().run();
//        new ConcurrentMapDemo().run();
        new ConcurrentHashMapDemo().run();
    }
}

class IncrementAndGet extends Base {

    AtomicInteger atomicInt = new AtomicInteger(0);

    @Override
    public void run() {
        IntStream.range(0, 1_000)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));
        stop(executor);
    }
}

class UpdateAndGet extends Base {

    AtomicInteger atomicInt = new AtomicInteger(0);

    @Override
    public void run() {
        IntStream.range(0, 1_000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.updateAndGet(n -> n + 2);
                    executor.submit(task);
                });
        stop(executor);
        System.out.println(atomicInt.get());
    }
}

class AccumulateAndGet extends Base {

    AtomicInteger atomicInt = new AtomicInteger(0);

    @Override
    protected void run() {
        IntStream.range(0, 1_000).forEach(i -> {
            Runnable task = () -> atomicInt.accumulateAndGet(i, (m, n) -> m + n);
            executor.submit(task);
        });
        stop(executor);
        System.out.println(atomicInt.get());
    }
}

class LongAdderDemo extends Base {

    LongAdder adder = new LongAdder();

    @Override
    protected void run() {
        IntStream.range(0, 1_000).forEach(i -> executor.submit(adder::increment));
        stop(executor);
        System.out.println(adder.sumThenReset());
    }
}

class LongAccumulatorDemo extends Base {

    LongBinaryOperator op = (x, y) -> 2 * x + y;
    LongAccumulator accumulator = new LongAccumulator(op, 1L);

    @Override
    protected void run() {
        IntStream.range(0, 10).forEach(i -> {
            executor.submit(() -> accumulator.accumulate(i));
        });
        stop(executor);
        System.out.println(accumulator.getThenReset());
    }
}

class ConcurrentMapDemo extends Base {

    @Override
    protected void run() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");
        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
        String result = map.putIfAbsent("c3", "p1");
        System.out.println(result);
        result = map.getOrDefault("hi", "there");
        System.out.println(result);
        map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
        System.out.println(map.get("r2"));
        map.compute("foo", (k, v) -> v + v);
        System.out.println(map.get("foo"));
        map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("foo"));
    }
}

class ConcurrentHashMapDemo extends Base {

    @Override
    protected void run() {
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");
        map.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n",
                key, value, Thread.currentThread().getName()));
        String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result);
        result = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result);
        result = map.reduce(1, (key, value) -> {
            System.out.println("Transform: " + Thread.currentThread().getName());
            return key + " = " + value;
        }, (s1, s2) -> {
            System.out.println("Reduce: " + Thread.currentThread().getName());
            return s1 + ", " + s2;
        });
        System.out.println("Result: " + result);
    }

}



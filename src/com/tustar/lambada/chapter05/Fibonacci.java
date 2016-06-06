package com.tustar.lambada.chapter05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tustar on 7/26/15.
 */
public class Fibonacci {

    private final Map<Integer, Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 1L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, n -> fibonacci(n - 1) + fibonacci(n - 2));
    }
}

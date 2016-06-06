package com.tustar.lambada.chapter06;

import java.util.stream.IntStream;

/**
 * Created by tustar on 7/27/15.
 */
public class SerialToParallel {

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

    public  static int sumOfSquares(IntStream range) {
        return range.parallel()
                .map(x -> x * x)
                .sum();
    }
}

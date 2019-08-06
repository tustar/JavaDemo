package com.tustar.gg.ch6;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Client {
    public static void main(String[] args) {
//        parallel();

        int[] arr = new int[100_00];

        Random random = new Random();
        Arrays.parallelSetAll(arr, (i) -> random.nextInt());
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void declaractive() {
        IntStream.range(1, 1_000_0000)
                .filter(PrimeUtil::isPrime)
                .forEach(System.out::println);
    }


    public static void parallel() {
        IntStream.range(1, 1_000_0000)
                .parallel()
                .filter(PrimeUtil::isPrime)
                .forEach(System.out::println);
    }
}

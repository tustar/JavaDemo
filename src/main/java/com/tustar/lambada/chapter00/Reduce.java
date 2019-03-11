package com.tustar.lambada.chapter00;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tustar on 7/26/15.
 */
public class Reduce {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            numbers.add(Integer.valueOf(i));
        }

        System.out.println("sum1 = " + numbers.stream()
                .reduce((r, e) -> r + e));

        System.out.println("sum2 = " + numbers.stream()
                .reduce(0, (r, e) -> r + e));

        System.out.println("sum3 = " + numbers.stream()
                .reduce(0, (r, e) -> r + e, (l, r) -> r));
    }
}

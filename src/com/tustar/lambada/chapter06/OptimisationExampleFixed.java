package com.tustar.lambada.chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tustar on 7/27/15.
 */
public class OptimisationExampleFixed {

    public int fastSumOfSquares(List<Integer> linkedListOfNumbers) {
        return new ArrayList<>(linkedListOfNumbers)
                .parallelStream()
                .mapToInt(x -> x * x)
                .sum();
    }
}

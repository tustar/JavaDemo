package com.tustar.lambada.chapter06;

import java.util.List;

/**
 * Created by tustar on 7/27/15.
 */
public class BuggyReduce {

    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers
                .parallelStream()
                .reduce(1, (acc, x) -> x * acc);
    }
}

package com.tustar.lambada.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Tu on 7/24/15.
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial, (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        List<I> newAcc = new ArrayList<I>(acc);
                        newAcc.add(x);
                        return newAcc;
                    } else {
                        return acc;
                    }
                },
                FilterUsingReduce::combineLists);
    }

    public static <I> List<I> combineLists(List<I> left, List<I> right) {
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }
}

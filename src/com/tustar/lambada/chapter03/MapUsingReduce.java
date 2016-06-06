package com.tustar.lambada.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Tu on 7/24/15.
 */
public class MapUsingReduce {
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            ArrayList<O> newLeft = new ArrayList<O>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }
}


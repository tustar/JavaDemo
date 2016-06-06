package com.tustar.lambada.chapter05;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by tustar on 7/26/15.
 */
public class Question1 {

    public static List<String> _1a() {
        return Stream.of("a", "b", "hello")
                .map(String::toUpperCase)
                .collect(toList());
    }

    public static int _1b() {
        return Stream.of(1, 2, 3)
                .reduce(0, Integer::sum);
    }

//    public static List<Integer> _1c() {
//        return Stream.of(asList(1, 2), asList(3, 4))
//                .flatMap(number -> Integer.valueOf(number))
//                .collect(toList());
//    }
}

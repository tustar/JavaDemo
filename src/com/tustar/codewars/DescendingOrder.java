package com.tustar.codewars;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by tustar on 7/26/15.
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        //Your code
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }
}

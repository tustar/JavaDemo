package com.tustar.lambada.chapter03;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tu on 7/24/15.
 */
public class StringExercises {

    public static int countLowercaseLetters(String string) {
        return (int) string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(StringExercises::countLowercaseLetters));
    }
}

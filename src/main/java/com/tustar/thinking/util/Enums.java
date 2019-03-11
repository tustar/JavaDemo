package com.tustar.thinking.util;

import java.util.Random;

/**
 * Created by tustar on 17-5-9.
 */
public class Enums {
    private static Random random = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}

package com.tustar.thinking;

import java.util.Random;

/**
 * Created by tustar on 17-6-2.
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T extends Enum<T>> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

}

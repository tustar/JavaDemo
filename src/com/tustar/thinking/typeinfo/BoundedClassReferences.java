package com.tustar.thinking.typeinfo;

/**
 * Created by tustar on 17-5-22.
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}

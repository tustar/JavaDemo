package com.tustar.thinking.typeinfo;

/**
 * Created by tustar on 17-5-22.
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}

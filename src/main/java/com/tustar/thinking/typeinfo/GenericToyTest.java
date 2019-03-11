package com.tustar.thinking.typeinfo;

/**
 * Created by tustar on 17-5-22.
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super  FancyToy> up = ftClass.getSuperclass();
        // This won't compile:
//        Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        Object obj = up.newInstance();
    }
}

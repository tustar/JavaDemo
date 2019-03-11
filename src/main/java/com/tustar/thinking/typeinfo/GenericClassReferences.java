package com.tustar.thinking.typeinfo;

/**
 * Created by tustar on 17-5-22.
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing
        intClass = double.class;
//        genericIntClass = double.class;
    }
}

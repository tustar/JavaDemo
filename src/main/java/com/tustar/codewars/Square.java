package com.tustar.codewars;

/**
 * Created by Tu on 7/31/15.
 */
public class Square {
    public static boolean isSquare(int n) {
        double value = Math.sqrt(n);
        return value == (int)value;
    }

    public static void main(String[] args) {
        System.out.println(Square.isSquare(25));
    }
}

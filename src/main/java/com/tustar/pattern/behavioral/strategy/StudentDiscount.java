package com.tustar.pattern.behavioral.strategy;

public class StudentDiscount implements Discount {

    private final double DISCOUNT = 0.8f;

    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * DISCOUNT;
    }
}

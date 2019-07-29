package com.tustar.pattern.behavioral.command.calculator;

public class Adder {

    private int num = 0;

    public int add(int value) {
        return num += value;
    }
}

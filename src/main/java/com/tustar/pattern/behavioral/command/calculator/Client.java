package com.tustar.pattern.behavioral.command.calculator;

public class Client {
    public static void main(String[] args) {

        CalculatorForm form = new CalculatorForm();
        form.setCommand(new AddCommand());

        form.compute(10);
        form.compute(5);
        form.compute(3);
        form.undo();
    }
}

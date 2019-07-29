package com.tustar.pattern.behavioral.command.calculator;

public class CalculatorForm {

    private ACommand command;

    public void setCommand(ACommand command) {
        this.command = command;
    }

    public void compute(int value) {
        int result = command.execute(value);
        System.out.println("执行运算，运算结果为:" + result);
    }

    public void undo() {
        int result = command.undo();
        System.out.println("执行撤销，运算结果为:" + result);
    }
}

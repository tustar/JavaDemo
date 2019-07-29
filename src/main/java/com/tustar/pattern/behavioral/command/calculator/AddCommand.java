package com.tustar.pattern.behavioral.command.calculator;

public class AddCommand extends ACommand {

    private Adder adder = new Adder();
    private int value;

    @Override
    public int execute(int value) {
        this.value = value;
        System.out.println("执行+" + value + "操作");
        return adder.add(value);
    }

    @Override
    public int undo() {
        System.out.println("撤回+" + value + "操作");
        return adder.add(-value);
    }
}

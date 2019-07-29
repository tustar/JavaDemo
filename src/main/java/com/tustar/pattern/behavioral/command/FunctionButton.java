package com.tustar.pattern.behavioral.command;

public class FunctionButton {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        System.out.print("单机功能键:");
        command.execute();
    }
}

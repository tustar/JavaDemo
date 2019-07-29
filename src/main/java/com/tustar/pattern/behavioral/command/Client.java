package com.tustar.pattern.behavioral.command;

public class Client {

    public static void main(String[] args) {
        FunctionButton fb = new FunctionButton();
        fb.setCommand(new ExitCommand());
        fb.click();
        //
        fb.setCommand(new HelpCommand());
        fb.click();
    }
}

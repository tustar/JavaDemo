package com.tustar.pattern.behavioral.command;

public class ConcreteCommand extends Command {

    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

package com.tustar.pattern.behavioral.command.calculator;

public abstract class ACommand {
    public abstract int execute(int value);
    public abstract int undo();
}

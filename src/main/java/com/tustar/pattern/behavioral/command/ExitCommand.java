package com.tustar.pattern.behavioral.command;

public class ExitCommand extends Command {

    private SystemExit setObj;

    public ExitCommand() {
        setObj = new SystemExit();
    }

    @Override
    public void execute() {
        setObj.exit();
    }
}

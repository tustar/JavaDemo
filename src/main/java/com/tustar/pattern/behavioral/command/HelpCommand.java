package com.tustar.pattern.behavioral.command;

public class HelpCommand extends Command {

    private DisplayHelp displayHelp;

    public HelpCommand() {
        displayHelp = new DisplayHelp();
    }

    @Override
    public void execute() {
        displayHelp.display();
    }
}

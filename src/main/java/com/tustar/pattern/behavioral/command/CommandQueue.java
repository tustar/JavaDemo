package com.tustar.pattern.behavioral.command;

import java.util.ArrayList;

public class CommandQueue {

    private ArrayList<Command> commands = new ArrayList<>();

    public boolean add(Command command) {
        return commands.add(command);
    }

    public boolean remove(Command command) {
        return commands.remove(command);
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

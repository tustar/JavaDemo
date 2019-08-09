package com.tustar.headfirst.designpatterns.command.remoteWL;

import java.util.Arrays;

public class RemoteControl {

    private static final int SIZE = 7;
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[SIZE];
        offCommands = new Command[SIZE];

        Command noCommand = new NoCommand();
        Arrays.fill(onCommands, noCommand);
        Arrays.fill(offCommands, noCommand);
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------Remote Control------\n");
        for (int i = 0; i < SIZE; i++) {
            stringBuffer.append("[slot " + i + "] "
                    + onCommands[i].getClass().getName()
                    + "    "
                    + offCommands[i].getClass().getName()
                    + "\n");
        }
        return stringBuffer.toString();
    }
}

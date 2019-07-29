package com.tustar.pattern.behavioral.command;

public class Invoker {

    private CommandQueue queue;

    public Invoker(CommandQueue queue) {
        this.queue = queue;
    }

    public void setQueue(CommandQueue queue) {
        this.queue = queue;
    }

    public void call() {
        queue.execute();
    }
}

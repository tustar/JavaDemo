package com.tustar.pattern.behavioral.memento;

class Memento {
    private String state;

    public Memento(Originator o) {
        state = o.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

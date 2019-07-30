package com.tustar.pattern.behavioral.memento;

public class Client {
    public static void main(String[] args) {

        Originator originator = new Originator("状态1");
        System.out.println(originator.getState());

        Caretaker ct = new Caretaker();
        ct.setMemento(originator.createMemento());

        originator.setState("状态2");
        System.out.println(originator.getState());

        originator.restoreMemento(ct.getMemento());
        System.out.println(originator.getState());
    }
}

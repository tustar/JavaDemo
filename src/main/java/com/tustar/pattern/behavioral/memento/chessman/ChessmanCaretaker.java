package com.tustar.pattern.behavioral.memento.chessman;

import java.util.ArrayList;

public class ChessmanCaretaker {

    private ArrayList<ChessmanMemento> mementos = new ArrayList<>();

    public ChessmanMemento getMemento(int i) {
        return mementos.get(i);
    }

    public void addMemento(ChessmanMemento memento) {
        mementos.add(memento);
    }
}

package com.tustar.pattern.behavioral.memento.chessman;

public class Client {

    private static int index = -1;
    private static ChessmanCaretaker caretaker = new ChessmanCaretaker();

    public static void main(String[] args) {


        Chessman chess = new Chessman("车", 1, 1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);

        undo(chess, index);
        undo(chess, index);
        redo(chess, index);
        redo(chess, index);
    }

    public static void display(Chessman chessman) {
        System.out.println("棋子" + chessman.getLabel() +
                "当前位置为:第" + chessman.getX() + "行第" + chessman.getY() + "列.");
    }

    public static void play(Chessman chess) {
        caretaker.addMemento(chess.save());
        index++;
        display(chess);
    }

    public static void undo(Chessman chess, int i) {
        System.out.println("***悔棋***");
        index--;
        chess.restore(caretaker.getMemento(i - 1));
        display(chess);
    }

    public static void redo(Chessman chess, int i) {
        System.out.println("***撤销悔棋***");
        index++;
        chess.restore(caretaker.getMemento(i + 1));
        display(chess);
    }
}

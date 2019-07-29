package com.tustar.pattern.structural.flyweight;

import java.util.Hashtable;

public class IgoChessmanFactory {

    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable<String, IgoChessman> chesses;

    private IgoChessmanFactory() {
        chesses = new Hashtable<>();
        BlackIgoChessman black = new BlackIgoChessman();
        WhiteIgoChessman white = new WhiteIgoChessman();
        chesses.put("b", black);
        chesses.put("w", white);
    }

    public static IgoChessmanFactory getIntance() {
        return instance;
    }

    public static IgoChessman getIgoChessman(String color) {
        return chesses.get(color);
    }
}

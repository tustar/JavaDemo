package com.tustar.pattern.structural.flyweight;

public abstract class IgoChessman {

    public abstract String getColor();

    public void display(Coordinates coord) {
        System.out.println("棋子颜色：" + getColor()
                + ", 位置：" + coord);
    }

    public void display(int x, int y) {
        display(new Coordinates(x, y));
    }
}

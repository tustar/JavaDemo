package com.tustar.headfirst.designpatterns.decorator;

public abstract class Beverage {
    String description = "Unknown Beverage";
    private int size;

    public static final int TALL = 0;
    public static final int GRANDE = 1;
    public static final int VENTI = 2;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

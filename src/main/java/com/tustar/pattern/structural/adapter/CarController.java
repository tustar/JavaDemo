package com.tustar.pattern.structural.adapter;

public abstract class CarController {

    public void move() {
        System.out.println("玩具汽车移动");
    }

    public abstract void phonate();
    public abstract void twinkle();
}

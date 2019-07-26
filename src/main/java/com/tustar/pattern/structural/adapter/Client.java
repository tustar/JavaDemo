package com.tustar.pattern.structural.adapter;

public class Client {

    public static void main(String[] args) {
        CarController carController = new PoliceCarAdapter();
        carController.move();
        carController.phonate();
        carController.twinkle();
    }
}

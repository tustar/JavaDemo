package com.tustar.pattern.behavioral.state;

public class Client {
    public static void main(String[] args) {
        H2O h2O = new H2O(20);
        h2O.coolDown(100);
        h2O.warmUp(120);
        h2O.coolDown(100);
    }
}

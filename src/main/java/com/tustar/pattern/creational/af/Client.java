package com.tustar.pattern.creational.af;

public class Client {
    public static void main(String[] args) {
        SkinFactory factory = new SpringSkinFactory();
        factory.display();
    }
}

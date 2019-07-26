package com.tustar.pattern.structural.bridge;

public class Client {

    public static void main(String[] args) {
        Image image = new JpgImage();
        ImageImp imp = new LinuxImp();
        image.setImp(imp);
        image.parseFile("小龙女");
    }
}

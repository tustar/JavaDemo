package com.tustar.pattern.structural.bridge;

public class JpgImage extends Image {

    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + ", 格式为Jpg.");
    }
}

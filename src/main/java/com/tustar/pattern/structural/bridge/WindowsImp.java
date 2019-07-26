package com.tustar.pattern.structural.bridge;

public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("在Windows操作系统中显示图像:");
    }
}

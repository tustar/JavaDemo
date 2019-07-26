package com.tustar.pattern.structural.bridge;

public class LinuxImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("在Linux操作系统中显示图像:");
    }
}

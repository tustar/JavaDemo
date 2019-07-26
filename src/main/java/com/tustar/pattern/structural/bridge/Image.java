package com.tustar.pattern.structural.bridge;

public abstract class Image {

    protected ImageImp imp;

    public void setImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}

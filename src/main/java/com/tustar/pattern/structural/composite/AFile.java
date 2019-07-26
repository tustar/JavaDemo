package com.tustar.pattern.structural.composite;

public abstract class AFile {

    public abstract void add(AFile file);
    public abstract void remove(AFile file);
    public abstract AFile getChild(int position);
    public abstract void killVirus();
}

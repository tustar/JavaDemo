package com.tustar.pattern.behavioral.iterator;

public interface Iterator {

    void first();

    void next();

    boolean hasNext();

    Object currentItem();
}

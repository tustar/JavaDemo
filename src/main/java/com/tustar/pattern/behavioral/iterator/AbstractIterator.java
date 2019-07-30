package com.tustar.pattern.behavioral.iterator;

public interface AbstractIterator {
    void next();
    boolean isLast();
    void previous();
    boolean isFirst();
    Object getNextItem();
    Object getPreviousItem();
}

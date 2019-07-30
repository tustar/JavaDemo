package com.tustar.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObjectList {

    protected List objects = new ArrayList();

    public AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void add(Object object) {
        objects.add(object);
    }

    public void remove(Object object) {
        objects.remove(object);
    }

    public List getObjects() {
        return objects;
    }

    public abstract AbstractIterator createIterator();
}

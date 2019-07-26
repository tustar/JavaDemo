package com.tustar.pattern.structural.adapter.classAdapter;

public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.specificRequest();
    }
}



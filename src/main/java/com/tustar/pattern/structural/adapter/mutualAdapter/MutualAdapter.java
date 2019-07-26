package com.tustar.pattern.structural.adapter.mutualAdapter;

public class MutualAdapter implements Target, Adaptee {

    private Target target;
    private Adaptee adaptee;

    public MutualAdapter(Target target) {
        this.target = target;
    }

    public MutualAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
    
    @Override
    public void specificRequest() {
        target.request();
    }
}

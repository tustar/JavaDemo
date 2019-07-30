package com.tustar.pattern.behavioral.interpreter;

public class DistanceNode extends AbstractNode {

    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return distance;
    }
}

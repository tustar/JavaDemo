package com.tustar.pattern.behavioral.interpreter;

public class SentenceNode extends AbstractNode {

    private DirectionNode direction;
    private AbstractNode action;
    private DistanceNode distance;

    public SentenceNode(DirectionNode direction, AbstractNode action, DistanceNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return direction.interpret() + action.interpret() + distance.interpret();
    }
}

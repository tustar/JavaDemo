package com.tustar.pattern.behavioral.mediator;

public abstract class Component {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void changed() {
        mediator.changed(this);
    }

    public abstract void update();
}

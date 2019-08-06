package com.tustar.headfirst.designpatterns.decorator;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public int getSize() {
        return beverage.getSize();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        switch (getSize()) {
            case TALL:
                cost += .10;
                break;
            case GRANDE:
                cost += .15;
                break;
            case VENTI:
                cost += .20;
                break;
            default:
                break;
        }
        return cost;
    }
}

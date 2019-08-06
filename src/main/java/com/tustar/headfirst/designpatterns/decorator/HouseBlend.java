package com.tustar.headfirst.designpatterns.decorator;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blean Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}

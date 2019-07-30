package com.tustar.pattern.behavioral.state;

public class Ice extends H2OState {

    public Ice(H2O h2O) {
        super(h2O);
    }

    @Override
    public void coolDown(int degree) {
        sculpture();
        super.coolDown(degree);
    }

    @Override
    public void warmUp(int degree) {
        sculpture();
        super.warmUp(degree);
    }

    @Override
    public void updateState() {
        if (h2O.getTemperature() >= 100) {
            h2O.setState(new Steam(h2O));
            System.out.println("冰．升华了");
            return;
        }

        if (h2O.getTemperature() > 0) {
            h2O.setState(new Water(h2O));
            System.out.println("冰．融化了");
            return;
        }
    }

    /**
     * 雕刻
     */
    public void sculpture() {
        System.out.println("原状态：冰=>可雕刻");
    }
}

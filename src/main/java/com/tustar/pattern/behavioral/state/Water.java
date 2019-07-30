package com.tustar.pattern.behavioral.state;

public class Water extends H2OState {

    public Water(H2O h2O) {
        super(h2O);
    }

    @Override
    public void coolDown(int degree) {
        flow();
        super.coolDown(degree);
    }

    @Override
    public void warmUp(int degree) {
        flow();
        super.warmUp(degree);
    }

    @Override
    public void updateState() {
        if (h2O.getTemperature() >= 100) {
            h2O.setState(new Steam(h2O));
            System.out.println("水．蒸发了");
            return;
        }

        if (h2O.getTemperature() <= 0) {
            h2O.setState(new Water(h2O));
            System.out.println("水．凝固了");
            return;
        }
    }

    public void flow() {
        System.out.println("原状态：水=>可流动");
    }
}

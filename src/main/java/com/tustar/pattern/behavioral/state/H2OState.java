package com.tustar.pattern.behavioral.state;

public abstract class H2OState {

    protected H2O h2O;

    public H2OState(H2O h2O) {
        this.h2O = h2O;
    }

    /**
     * 降温
     */
    public void coolDown(int degree) {
        h2O.setTemperature(h2O.getTemperature() - degree);
        System.out.println("H20, 现在温度" + h2O.getTemperature() + "度");
        updateState();
    }

    /**
     * 升温
     */
    public void warmUp(int degree) {
        h2O.setTemperature(h2O.getTemperature() + degree);
        System.out.println("H20, 现在温度" + h2O.getTemperature() + "度");
        updateState();
    }

    /**
     * 检查温度
     */
    public abstract void updateState();
}

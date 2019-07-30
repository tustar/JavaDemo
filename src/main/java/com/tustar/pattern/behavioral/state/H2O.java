package com.tustar.pattern.behavioral.state;

public class H2O {

    private H2OState state;
    private int temperature;

    public H2O(int temperature) {
        this.temperature = temperature;
        state = H2OStateFactory.findState(this);
    }

    public H2OState getState() {
        return state;
    }

    public void setState(H2OState state) {
        this.state = state;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * 降温
     */
    public void coolDown(int degree) {
        System.out.println("H20, 从温度" + temperature + "度降温" + degree + "度");
        state.coolDown(degree);
    }

    /**
     * 升温
     */
    public void warmUp(int degree) {
        System.out.println("H20, 从温度" + temperature + "度升温" + degree + "度");
        state.warmUp(degree);
    }
}

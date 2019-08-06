package com.tustar.pattern.behavioral.state;

public class H2O {

    private H2OState state;
    private int temperature;

    public H2O(int temperature) {
        this.temperature = temperature;
        state = initState();
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
        System.out.print("温度：" + temperature + "-" + degree);
        temperature = temperature - degree;
        System.out.println("=" + temperature);
        state.updateState(this);
    }

    /**
     * 升温
     */
    public void warmUp(int degree) {
        System.out.print("温度：" + temperature + "+" + degree);
        temperature = temperature + degree;
        System.out.println("=" + temperature);
        state.updateState(this);
    }

    public H2OState initState() {
        if (temperature < 0) {
            return new Ice();
        }

        if (temperature >= 100) {
            return new Steam();
        }

        return new Water();
    }
}

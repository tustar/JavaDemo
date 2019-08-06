package com.tustar.pattern.behavioral.state;

public abstract class H2OState {
    /**
     * 检查温度
     */
    public abstract void updateState(H2O h2O);
}

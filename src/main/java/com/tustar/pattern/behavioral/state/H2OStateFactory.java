package com.tustar.pattern.behavioral.state;

public class H2OStateFactory {

    public static H2OState findState(H2O h2O) {
        if (h2O.getTemperature() < 0) {
            return new Ice(h2O);
        }

        if (h2O.getTemperature() >= 100) {
            return new Steam(h2O);
        }

        return new Water(h2O);
    }
}

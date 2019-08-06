package com.tustar.pattern.behavioral.state;

public class Water extends H2OState {

    @Override
    public void updateState(H2O h2O) {
        if (h2O.getTemperature() >= 100) {
            System.out.print("水．蒸发了,");
            h2O.setState(new Steam());
            System.out.println("水=>水蒸气");
            return;
        }

        if (h2O.getTemperature() <= 0) {
            System.out.print("水．凝固了,");
            h2O.setState(new Ice());
            System.out.println("水=>冰");
            return;
        }

        System.out.print("   状态未变化, 水, ");
        flow();
    }

    public void flow() {
        System.out.println("水=>可流动");
    }
}

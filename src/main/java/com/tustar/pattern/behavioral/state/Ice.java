package com.tustar.pattern.behavioral.state;

public class Ice extends H2OState {

    @Override
    public void updateState(H2O h2O) {
        if (h2O.getTemperature() >= 100) {
            System.out.print("冰．升华了，");
            h2O.setState(new Steam());
            System.out.println("冰=>水蒸气");
            return;
        }

        if (h2O.getTemperature() > 0) {
            System.out.print("冰．融化了，");
            h2O.setState(new Water());
            System.out.println("冰=>水");
            return;
        }

        System.out.print("   状态未变化, 冰, ");
        sculpture();
    }

    /**
     * 雕刻
     */
    public void sculpture() {
        System.out.println("冰=>可雕刻");
    }
}

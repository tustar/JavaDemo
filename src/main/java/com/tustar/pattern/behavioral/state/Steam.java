package com.tustar.pattern.behavioral.state;

/**
 * 水蒸气
 */
public class Steam extends H2OState {

    @Override
    public void updateState(H2O h2O) {
        if (h2O.getTemperature() > 0) {
            System.out.print("水蒸气．液华了，");
            h2O.setState(new Water());
            System.out.println("水蒸气=>水");
            return;
        }

        if (h2O.getTemperature() <= 0) {
            System.out.print("水蒸气．凝化了，");
            h2O.setState(new Ice());
            System.out.println("水蒸气=>冰");
            return;
        }

        System.out.print("   状态未变化, 水蒸气, ");
        diffusion();
    }

    /**
     * 扩散
     */
    public void diffusion() {
        System.out.println("水蒸气=>可扩散");
    }
}

package com.tustar.pattern.behavioral.state;

/**
 * 水蒸气
 */
public class Steam extends H2OState {

    public Steam(H2O h2O) {
        super(h2O);
    }

    @Override
    public void coolDown(int degree) {
        diffusion();
        super.coolDown(degree);
    }

    @Override
    public void warmUp(int degree) {
        diffusion();
        super.warmUp(degree);
    }

    @Override
    public void updateState() {
        if (h2O.getTemperature() > 0) {
            h2O.setState(new Steam(h2O));
            System.out.println("水蒸气．液华了");
            return;
        }

        if (h2O.getTemperature() <= 0) {
            h2O.setState(new Water(h2O));
            System.out.println("水蒸气．凝化了");
            return;
        }
    }

    /**
     * 扩散
     */
    public void diffusion() {
        System.out.println("原状态：水蒸气=>可扩散");
    }
}

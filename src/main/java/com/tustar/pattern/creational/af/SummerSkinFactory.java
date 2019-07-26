package com.tustar.pattern.creational.af;

public class SummerSkinFactory implements SkinFactory {

    public SummerSkinFactory() {
        System.out.println("夏天皮肤");
    }

    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
}

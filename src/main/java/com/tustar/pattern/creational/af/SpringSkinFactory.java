package com.tustar.pattern.creational.af;

public class SpringSkinFactory implements SkinFactory {

    public SpringSkinFactory() {
        System.out.println("春天皮肤");
    }

    @Override
    public Button createButton() {
        return new SpringButton();
    }


    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
}

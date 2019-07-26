package com.tustar.pattern.creational.af;

public interface SkinFactory {
    Button createButton();

    TextField createTextField();

    default void display() {
        Button button = createButton();
        TextField textField = createTextField();
        button.display();
        textField.display();
    }
}

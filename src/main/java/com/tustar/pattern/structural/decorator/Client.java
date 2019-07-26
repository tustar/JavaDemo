package com.tustar.pattern.structural.decorator;

public class Client {
    public static void main(String[] args) {
        Window window = new Window();
        ScrollBarDecorator scrollBarDecorator = new ScrollBarDecorator(window);
        BlackBorderDecorator blackBorderDecorator = new BlackBorderDecorator(scrollBarDecorator);
        blackBorderDecorator.display();
    }
}

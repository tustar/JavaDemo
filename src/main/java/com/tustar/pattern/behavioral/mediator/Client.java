package com.tustar.pattern.behavioral.mediator;

public class Client {
    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();

        Button addBtn = new Button();
        List list = new List();
        ComboBox comboBox = new ComboBox();
        TextBox textBox = new TextBox();

        addBtn.setMediator(mediator);
        list.setMediator(mediator);
        comboBox.setMediator(mediator);
        textBox.setMediator(mediator);


        mediator.addBtn = addBtn;
        mediator.list = list;
        mediator.comboBox = comboBox;
        mediator.userNameTextBox = textBox;

        addBtn.changed();
        System.out.println("----------------");
        list.changed();
    }
}

package com.tustar.pattern.behavioral.mediator;

public class ConcreteMediator extends Mediator {

    public Button addBtn;
    public List list;
    public TextBox userNameTextBox;
    public ComboBox comboBox;

    @Override
    public void changed(Component c) {
        if (c == addBtn) {
            System.out.println("－－单击增加按钮－－");
            list.update();
            comboBox.update();
            userNameTextBox.update();
        } else if (c == list) {
            System.out.println("－－从列表框选择客户－－");
            comboBox.select();
            userNameTextBox.setText();
        } else if (c == comboBox) {
            System.out.println("－－从组合框选择客户－－");
            comboBox.select();
            userNameTextBox.setText();

        }
    }
}

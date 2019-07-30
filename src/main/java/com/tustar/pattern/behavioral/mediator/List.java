package com.tustar.pattern.behavioral.mediator;

public class List extends Component {

    @Override
    public void update() {
        System.out.println("列表项增加一项:张无忌．");
    }

    public void select() {
        System.out.println("列表框选中项:小龙女．");
    }
}

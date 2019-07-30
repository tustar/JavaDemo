package com.tustar.pattern.behavioral.observer;

public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住，" + name + "正在赶往支援！");
    }

    @Override
    public void beAttacked(AllyControlCenter center) {
        System.out.println(name + "被攻击！");
        center.notifyPlayer(name);
    }
}

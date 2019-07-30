package com.tustar.pattern.behavioral.observer;

import java.util.ArrayList;

public abstract class AllyControlCenter {

    protected String allyName;
    protected ArrayList<Observer> players = new ArrayList<>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void add(Observer player) {
        System.out.println(player.getName() + "加入" + allyName + "战队");
        players.add(player);
    }

    public void quit(Observer player) {
        System.out.println(player.getName() + "退出" + allyName + "战队");
        players.remove(player);
    }

    public abstract void notifyPlayer(String name);
}

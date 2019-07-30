package com.tustar.pattern.behavioral.observer;

public class Client {

    public static void main(String[] args) {
        AllyControlCenter ally = new ConcreteAllyControlCenter("群侠队");

        Player yg = new Player("杨过");
        ally.add(yg);

        Player xln = new Player("小龙女");
        ally.add(xln);

        Player gj = new Player("郭靖");
        ally.add(gj);

        Player qf = new Player("乔峰");
        ally.add(qf);
        
        xln.beAttacked(ally);
    }
}

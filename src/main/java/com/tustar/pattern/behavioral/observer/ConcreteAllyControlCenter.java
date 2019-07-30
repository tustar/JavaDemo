package com.tustar.pattern.behavioral.observer;

public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "战队组件成功！");
        System.out.println("----------------");
        this.allyName = allyName;
    }

    @Override
    public void notifyPlayer(String name) {
        System.out.println(allyName + "战队紧急通知，队友" + name + "遭受敌人攻击，请求支援！");
        for (Observer player : players) {
            if (!player.getName().equalsIgnoreCase(name)) {
                player.help();
            }
        }
    }
}

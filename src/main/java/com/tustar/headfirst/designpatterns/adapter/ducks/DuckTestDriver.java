package com.tustar.headfirst.designpatterns.adapter.ducks;

public class DuckTestDriver {

    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The turkey says ...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Dock says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(duck);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}

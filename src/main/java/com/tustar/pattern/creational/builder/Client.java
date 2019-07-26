package com.tustar.pattern.creational.builder;

public class Client {

    public static void main(String[] args) {

        ActorBuilder actorBuilder = new HeroBuilder();
        Actor actor = ActorBuilder.construct(actorBuilder);
        System.out.println("actor = " + actor);
    }
}

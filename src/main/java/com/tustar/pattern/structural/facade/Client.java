package com.tustar.pattern.structural.facade;

public class Client {

    public static final String PATH = "/home/tustar/Documents/project/bitbucket/JavaDemo/src/main/java/com/tustar/pattern/structural/facade";

    public static void main(String[] args) {
        AbstractEncryptFacade facade = new NewEncryptFacade();
        facade.encrypt(PATH + "//" + "src.txt", PATH + "//" + "dest.txt");
    }
}

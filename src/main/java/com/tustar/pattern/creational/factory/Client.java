package com.tustar.pattern.creational.factory;

public class Client {
    public static void main(String[] args) {
        // 方式一
        System.out.println("------------------");
        System.out.println("方式一");
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger();
        logger.writeLog();
        System.out.println("------------------");
        System.out.println("方式二");
        // 方式二
        new DatabaseLoggerFactory().writeLog();
    }
}

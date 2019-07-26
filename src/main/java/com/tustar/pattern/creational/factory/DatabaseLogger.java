package com.tustar.pattern.creational.factory;

public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录.");
    }
}

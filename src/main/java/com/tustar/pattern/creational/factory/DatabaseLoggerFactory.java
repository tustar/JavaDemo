package com.tustar.pattern.creational.factory;

public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        Logger logger = new DatabaseLogger();
        return logger;
    }
}

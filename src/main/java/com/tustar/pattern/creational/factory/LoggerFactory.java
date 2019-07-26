package com.tustar.pattern.creational.factory;

public interface LoggerFactory {
    Logger createLogger();

    default void writeLog() {
        Logger logger = createLogger();
        logger.writeLog();
    }
}

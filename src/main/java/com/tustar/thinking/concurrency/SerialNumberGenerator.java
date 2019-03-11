package com.tustar.thinking.concurrency;

/**
 * Created by tustar on 17-5-4.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}

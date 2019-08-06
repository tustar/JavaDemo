package com.tustar.pattern.behavioral.state;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        H2O h2O = new H2O(20);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                h2O.warmUp(random.nextInt(100));
            } else {
                h2O.coolDown(random.nextInt(50));
            }

            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

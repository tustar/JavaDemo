package com.tustar.gg.ch6;

public class PrimeUtil {

    private PrimeUtil() {
    }

    public static boolean isPrime(int number) {
        int tmp = number;
        if (tmp < 2) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(tmp); i++) {
            if (tmp % i == 0) {
                return false;
            }
        }

        return true;
    }
}

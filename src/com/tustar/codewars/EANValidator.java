package com.tustar.codewars;

import java.util.stream.IntStream;

/**
 * Created by tustar on 7/26/15.
 */
public class EANValidator {
//    public static boolean validate(final String eanCode) {
//        int sum = 0;
//        for (int i = 0; i < eanCode.length() - 1; i++) {
//            if (i % 2 == 1) {
//                sum += Integer.valueOf(String.valueOf(eanCode.charAt(i))) * 3;
//            } else {
//                sum += Integer.valueOf(String.valueOf(eanCode.charAt(i)));
//            }
//        }
//        int checksum = 0;
//        if (sum % 10 != 0) {
//            checksum = 10 - (sum % 10);
//        }
//        return checksum == Integer.valueOf(String.valueOf(eanCode.charAt(eanCode.length() - 1)));
//    }

    private static int factor = 3;

    public static boolean validate(final String eanCode) {

        int checksum = eanCode
                .chars()
                .limit(eanCode.length() - 1)
                .map(i -> Character.getNumericValue((char) i))
                .reduce(0, (sum, i) -> {
                    factor = factor == 1 ? 3 : 1;
                    return sum + i * factor;
                });
        checksum = (checksum % 10 == 0 ? 0 : 10 - (checksum % 10));
        return checksum == Character.getNumericValue(eanCode.charAt(eanCode.length() - 1));
    }
}

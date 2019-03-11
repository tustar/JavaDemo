package com.tustar.calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tustar on 16-6-7.
 */
public class Format {
    public static void main(String[] args) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("log\\d+");
        Matcher matcher = pattern.matcher("2√(sin(log10(1)log234");
        while(matcher.find()) {
            System.out.println(true);
            int groupCount = matcher.groupCount();
            System.out.println("groupCount = " + groupCount);
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("init :: log group = " + matcher.group(i));
            }
        }
    }
}

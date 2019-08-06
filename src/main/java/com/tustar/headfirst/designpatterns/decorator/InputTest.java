package com.tustar.headfirst.designpatterns.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    private static final String PATH = "/home/tustar/Documents/project/bitbucket/JavaDemo/src/main/java/com/tustar/headfirst/decorator";
    public static void main(String[] args) {
        int c;
        try {
            InputStream is = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(PATH + "/test.txt")

                    )
            );

            while ((c = is.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

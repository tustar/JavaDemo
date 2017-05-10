package com.tustar.thinking.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by tustar on 17-5-10.
 */
public class MemoryInput {
    public static void main(String[] args) {
        try {
            StringReader in = new StringReader(BufferedInputFile.read(MemoryInput.class, "MemoryInput.java"));
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;

/**
 * Created by tustar on 17-5-10.
 */
public class TestEOF {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(
                    new FileInputStream(FileUtils.getSrcJavaFilePath(TestEOF.class, "TestEOF.java"))));
            while (in.available() != 0) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tustar on 17-5-10.
 */
public class BufferedInputFile {

    public static String read(Class<?> clazz, String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(FileUtils.getSrcJavaFilePath(
                clazz, filename)));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(read(BufferedInputFile.class, "BufferedInputFile.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

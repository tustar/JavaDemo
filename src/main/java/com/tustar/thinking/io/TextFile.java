package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by tustar on 17-5-10.
 */
public class TextFile extends ArrayList<String> {
    // Read a file as a single string:
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
    // Write a single file in one method call:
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }
    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item: this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read(FileUtils.getSrcJavaFilePath(TextFile.class, "TextFile.java"));
        write(FileUtils.getSrcJavaFilePath(TextFile.class, "test.txt"), file);
        TextFile textFile = new TextFile(FileUtils.getSrcJavaFilePath(TextFile.class, "test.txt"));
        textFile.write(FileUtils.getSrcJavaFilePath(TextFile.class, "test2.txt"));
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<>(new TextFile(FileUtils.getSrcJavaFilePath(TextFile.class,
                "TextFile.java"), "\\W+"));
        System.out.println(words.headSet("a"));
    }
}

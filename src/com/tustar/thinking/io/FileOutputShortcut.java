package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by tustar on 17-5-10.
 */
public class FileOutputShortcut {
    static String filename = "FileOutputShortcut.out";
    static String file = FileUtils.getSrcJavaFilePath(FileOutputShortcut.class, filename);

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(FileOutputShortcut.class,
                    "FileOutputShortcut.java")));
            PrintWriter out = new PrintWriter(file);
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null) {
                out.println(lineCount++ + ": " + s);
            }
            out.close();
            System.out.println(BufferedInputFile.read(FileOutputShortcut.class, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

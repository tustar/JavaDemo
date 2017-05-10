package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;

/**
 * Created by tustar on 17-5-10.
 */
public class BasicFileOutput {
    static String filename = "BasicFileOutput.out";
    static String file = FileUtils.getSrcJavaFilePath(BasicFileOutput.class, filename);

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new StringReader(
                    BufferedInputFile.read(BasicFileOutput.class, "BasicFileOutput.java")));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null) {
                out.println(lineCount++ + ": " + s);
            }
            out.close();
            System.out.println(BufferedInputFile.read(BasicFileOutput.class, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;

/**
 * Created by tustar on 17-5-10.
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                FileUtils.getSrcJavaFilePath(Redirecting.class, "Redirecting.java")));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(
                FileUtils.getSrcJavaFilePath(Redirecting.class, "test.out")
        )));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }
}

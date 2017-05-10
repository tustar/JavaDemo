package com.tustar.thinking.io;

import java.io.PrintWriter;

/**
 * Created by tustar on 17-5-10.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello world");
    }
}

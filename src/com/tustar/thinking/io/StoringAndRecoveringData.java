package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;

/**
 * Created by tustar on 17-5-10.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(
                FileUtils.getSrcJavaFilePath(StoringAndRecoveringData.class, "Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new FileInputStream(
                FileUtils.getSrcJavaFilePath(StoringAndRecoveringData.class, "Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}

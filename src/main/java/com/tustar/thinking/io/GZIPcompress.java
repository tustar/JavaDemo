package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by tustar on 17-5-11.
 */
public class GZIPcompress {
    private static String file = FileUtils.getSrcJavaFilePath(GZIPcompress.class, "test.gz");
    public static void main(String[] args) throws IOException {
        System.out.println(file);
        if (args.length == 0) {
            System.out.println("Usage: \nGZIPcompress file\n" +
                    "\tUses GZIP compression to compress " +
                    "the file to test.gz");
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file))));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
    }
}

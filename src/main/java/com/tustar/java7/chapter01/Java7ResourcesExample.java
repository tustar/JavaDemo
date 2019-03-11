package com.tustar.java7.chapter01;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tustar on 7/30/15.
 */
public class Java7ResourcesExample {

    private void run() throws IOException {
        File file = new File("foo");
        URL url = null;
        try {
            url = new URL("http://www.google.com/");
        } catch (MalformedURLException e) {
        }

        try (OutputStream out = new FileOutputStream(file);
             InputStream is = url.openStream()) {
            byte[] buf = new byte[4096];
            int len;
            while ((len = is.read(buf)) >= 0) {
                out.write(buf, 0, len);
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Java7ResourcesExample instance = new Java7ResourcesExample();
        instance.run();
    }

}

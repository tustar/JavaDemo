package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-5-11.
 */
public class FileLocking {
    private static String file = FileUtils.getSrcJavaFilePath(FileLocking.class, "file.txt");

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(file);
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}

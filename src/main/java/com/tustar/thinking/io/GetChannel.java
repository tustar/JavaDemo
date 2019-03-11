package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tustar on 17-5-11.
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    private static String file = FileUtils.getSrcJavaFilePath(GetChannel.class, "data.txt");

    public static void main(String[] args) throws Exception {
        // Write a file:
        FileChannel fc = new FileOutputStream(file)
                .getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        // Add to the end of the file:
        fc = new RandomAccessFile(file, "rw").getChannel();
        fc.position(fc.size()); // Move to the end
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();
        // Read the file:
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
    }
}

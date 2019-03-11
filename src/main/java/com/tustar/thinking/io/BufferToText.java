package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by tustar on 17-5-11.
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    private static String file = FileUtils.getSrcJavaFilePath(GetChannel.class, "data2.txt");

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        // Doesn't work:
        System.out.println(buffer.asCharBuffer());
        // Decode using this system's default Charset:
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buffer));
        // Or, we could encode with something that will print:
        fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        // Now try reading again:
        fc = new FileInputStream(file).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        // Use a CharBuffer to write through:
        fc = new FileOutputStream(file).getChannel();
        buffer = ByteBuffer.allocate(24); // More than needed
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();
        // Read and display:
        fc = new FileInputStream(file).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}

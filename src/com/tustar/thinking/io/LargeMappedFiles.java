package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tustar on 17-5-11.
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF; // 128MB

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile(
                FileUtils.getSrcJavaFilePath(LargeMappedFiles.class, "test.dat"), "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char) out.get(i));
        }

    }
}

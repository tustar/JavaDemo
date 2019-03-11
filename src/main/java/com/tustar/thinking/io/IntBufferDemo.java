package com.tustar.thinking.io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by tustar on 17-5-11.
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        // Store an array of int:
        intBuffer.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        // Absolute location read and write:
        System.out.println(intBuffer.get(3));
        intBuffer.put(3, 1811);
        // Setting a new limit before rewinding the buffer.
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }
    }
}

package com.tustar.thinking.io;

import java.nio.ByteBuffer;

/**
 * Created by tustar on 17-5-11.
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        // Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while (i++ < byteBuffer.limit()) {
            if (byteBuffer.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);
        byteBuffer.rewind();
        // Store and read a char array:
        byteBuffer.asCharBuffer().put("Howdy!");
        char c;
        while ((c = byteBuffer.getChar()) != 0){
            System.out.print(c + " ");
        }
        System.out.println();
        byteBuffer.rewind();
        // Store and read a short:
        byteBuffer.asShortBuffer().put((short)471142);
        System.out.println(byteBuffer.getShort());
        byteBuffer.rewind();
        // Store and read a int:
        byteBuffer.asIntBuffer().put(99471142);
        System.out.println(byteBuffer.getInt());
        byteBuffer.rewind();
        // Store and read a long:
        byteBuffer.asLongBuffer().put(99471142);
        System.out.println(byteBuffer.getLong());
        byteBuffer.rewind();
        // Store and read a float:
        byteBuffer.asFloatBuffer().put(99471142);
        System.out.println(byteBuffer.getFloat());
        byteBuffer.rewind();
        // Store and read a double:
        byteBuffer.asDoubleBuffer().put(99471142);
        System.out.println(byteBuffer.getDouble());
        byteBuffer.rewind();
    }
}

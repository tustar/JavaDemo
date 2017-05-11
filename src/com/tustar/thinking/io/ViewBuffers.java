package com.tustar.thinking.io;

import java.nio.*;

/**
 * Created by tustar on 17-5-11.
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        System.out.print("Byte Buffer ");
        while (bb.hasRemaining()) {
            System.out.print(bb.position() + " -> " + bb.get() + ", ");
        }
        System.out.println();
        // Char
        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        System.out.print("Char Buffer ");
        while (cb.hasRemaining()) {
            System.out.print(cb.position() + " -> " + cb.get() + ", ");
        }
        System.out.println();
        // Float
        FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
        System.out.print("Float Buffer ");
        while (fb.hasRemaining()) {
            System.out.print(fb.position() + " -> " + fb.get() + ", ");
        }
        System.out.println();
        // Int
        IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
        System.out.print("Int Buffer ");
        while (ib.hasRemaining()) {
            System.out.print(ib.position() + " -> " + ib.get() + ", ");
        }
        System.out.println();
        // Long
        LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
        System.out.print("Long Buffer ");
        while (lb.hasRemaining()) {
            System.out.print(lb.position() + " -> " + lb.get() + ", ");
        }
        System.out.println();
        // Short
        ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
        System.out.print("Short Buffer ");
        while (sb.hasRemaining()) {
            System.out.print(sb.position() + " -> " + sb.get() + ", ");
        }
        System.out.println();
        // Double
        DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
        System.out.print("Double Buffer ");
        while (db.hasRemaining()) {
            System.out.print(db.position() + " -> " + db.get() + ", ");
        }
        System.out.println();
    }
}

package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by tustar on 17-5-11.
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF; // 128MB
    private static String file = FileUtils.getSrcJavaFilePath(LargeMappedFiles.class, "test.dat");
    static FileChannel fc;

    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');
        }
        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buffer;
        private int start, end;

        public LockAndModify(MappedByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buffer = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                // Exclusive lock with no overlap:
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                // Perform modification:
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte) (buffer.get() + 1));
                }
                fl.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

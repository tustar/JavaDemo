package com.tustar.headfirst.designpatterns.decorator;

import org.jetbrains.annotations.NotNull;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream is) {
        super(is);
    }

    @Override
    public int read() throws IOException {
        int ch = super.read();
        return (ch == -1 ? ch : Character.toLowerCase(ch));
    }

    @Override
    public int read(@NotNull byte[] b) throws IOException {
        int length = super.read(b);
        for (int i = 0; i < length; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return length;
    }

    @Override
    public int read(@NotNull byte[] b, int off, int len) throws IOException {
        int length = super.read(b, off, len);
        for (int i = off; i < off + length; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return length;
    }
}

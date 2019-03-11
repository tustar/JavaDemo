package com.tustar.thinking.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by tustar on 17-5-10.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(
                    BufferedInputFile.read(FormattedMemoryInput.class,
                            "FormattedMemoryInput.java").getBytes()));
            while (true) {
                System.out.print((char) in.readByte());
            }
        } catch (EOFException e) {
            System.out.println("End of stream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;
import java.util.Random;

/**
 * Created by tustar on 17-5-11.
 */
class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class Worm implements Serializable {
    private static Random random = new Random(47);
    private Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    public Worm(){
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data:d) {
            result.append(data);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    private static String file = FileUtils.getSrcJavaFilePath(Worm.class, "worm.out");
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();// Also flushes output
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println(s + " w2 = " + w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w2);
        out.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println(s + " w3 = " + w3);
    }
}

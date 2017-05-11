package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;

/**
 * Created by tustar on 17-5-11.
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s; // No initialization
    public Blip3() {
        System.out.println("Blip3 constructor");
        // s, i not initialized
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
        // s & i initialized only in non-default constructor.
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        // You must do this:
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // You must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }

    private static String file = FileUtils.getSrcJavaFilePath(Blip3.class, "Blip3.out");
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects: ");
        Blip3 blip3 = new Blip3("A String ", 47);
        System.out.println(blip3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
        System.out.println("Saving object:");
        o.writeObject(blip3);
        o.close();
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        System.out.println("Recovering blip3:");
        blip3 = (Blip3) in.readObject();
        System.out.println(blip3);
    }
}

package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;

/**
 * Created by tustar on 17-5-11.
 */
class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        System.out.println("Blip2 constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {
    private static String file = FileUtils.getSrcJavaFilePath(Blips.class, "Blips.out");
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
        System.out.println("Saving objects: ");
        o.writeObject(blip1);
        o.writeObject(blip2);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        System.out.println("Recovering blip1:");
        blip1 = (Blip1)in.readObject();
        // OOPS! Throws an exception:
        System.out.println("Recovering blip2:");
        blip2 = (Blip2)in.readObject();
    }
}

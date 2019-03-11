package com.tustar.thinking.io;

import java.io.*;

/**
 * Created by tustar on 17-5-16.
 */
public class SerialCtl implements Serializable {

    private String a;
    private transient String b;

    public SerialCtl(String a, String b) {
        this.a = "Not Transient: " + a;
        this.b = "Transient: " + b;
    }

    @Override
    public String toString() {
        return "SerialCtl{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        out.defaultWriteObject();
        out.writeObject(b);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        b = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl serialCtl = new SerialCtl("Test1", "Test2");
        System.out.println("Before: \n" + serialCtl);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(serialCtl);
        // Now get it back:
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        SerialCtl serialCtl2 = (SerialCtl) ois.readObject();
        System.out.println("After: \n" + serialCtl2);
    }
}

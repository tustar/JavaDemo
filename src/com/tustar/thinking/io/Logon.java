package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tustar on 17-5-16.
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private static String file = FileUtils.getSrcJavaFilePath(Logon.class, "Logon.out");
    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(a);
        out.close();
        TimeUnit.SECONDS.sleep(1); // Delay
        // New get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        System.out.println("Recovering object at " + new Date());
        a = (Logon)in.readObject();
        System.out.println("logon a = " + a);
    }
}

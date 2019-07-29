package com.tustar.pattern.structural.facade;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public void write(String encryptStr, String dest) {
        System.out.print("保存密文，写入文件．");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dest);
            fos.write(encryptStr.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件操作错误！");
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

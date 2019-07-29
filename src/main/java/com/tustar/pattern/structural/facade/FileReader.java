package com.tustar.pattern.structural.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public String read(String src) {
        System.out.print("读取文件，获取明文:");
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
            int data;
            while ((data = fis.read()) != -1) {
                sb = sb.append((char) data);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件操作错误！");
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}

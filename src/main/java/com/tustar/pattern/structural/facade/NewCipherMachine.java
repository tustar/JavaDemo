package com.tustar.pattern.structural.facade;

public class NewCipherMachine {
    public String encrypt(String plainText) {
        System.out.print("数据加密，将明文转换为密文:");
        String es = "";
        int key = 10;
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            // Low letter
            if (c > 'a' && c < 'z') {
                c += key % 26;
                if (c > 'z') {
                    c -= 26;
                }
                if (c < 'a') {
                    c += 26;
                }
            }
            // Upper letter
            if (c > 'A' && c < 'Z') {
                c += key % 26;
                if (c > 'Z') {
                    c -= 26;
                }
                if (c < 'A') {
                    c += 26;
                }
            }
            //
            es += c;
        }
        System.out.println(es);
        return es;
    }
}

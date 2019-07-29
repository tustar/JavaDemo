package com.tustar.pattern.structural.facade;

public class NewEncryptFacade extends AbstractEncryptFacade {

    private FileReader reader;
    private NewCipherMachine cipher;
    private FileWriter writer;

    public NewEncryptFacade() {
        reader = new FileReader();
        cipher = new NewCipherMachine();
        writer = new FileWriter();
    }

    @Override
    public void encrypt(String src, String dest) {
        String plainText = reader.read(src);
        String encryStr = cipher.encrypt(plainText);
        writer.write(encryStr, dest);
    }
}

package com.tustar.pattern.structural.facade;

public class EncryptFacade extends AbstractEncryptFacade {

    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    @Override
    public void encrypt(String src, String dest) {
        String plainText = reader.read(src);
        String encryStr = cipher.encrypt(plainText);
        writer.write(encryStr, dest);
    }
}

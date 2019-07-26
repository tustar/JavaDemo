package com.tustar.pattern.structural.composite;

public class TextFile extends AFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }


    @Override
    public void add(AFile file) {
        System.out.println("对不起,不支持该方法!");
    }

    @Override
    public void remove(AFile file) {
        System.out.println("对不起,不支持该方法!");
    }

    @Override
    public AFile getChild(int position) {
        System.out.println("对不起,不支持该方法!");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("====>对文本文件'" + name + "'进行杀毒");
    }
}

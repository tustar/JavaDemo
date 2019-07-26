package com.tustar.pattern.structural.composite;

import java.util.ArrayList;

public class Folder extends AFile {

    private ArrayList<AFile> fileList = new ArrayList<>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }


    @Override
    public void add(AFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AFile file) {
        fileList.remove(file);
    }

    @Override
    public AFile getChild(int position) {
        return fileList.get(position);
    }

    @Override
    public void killVirus() {
        System.out.println("＊＊＊>对文件夹'" + name + "'进行杀毒");
        for (AFile file : fileList) {
            file.killVirus();
        }
    }
}

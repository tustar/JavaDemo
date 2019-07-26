package com.tustar.pattern.structural.composite;

public class Client {

    public static void main(String[] args) {

        Folder imageFolder = new Folder("图像文件");
        imageFolder.add(new ImageFile("小龙女.jpg"));
        imageFolder.add(new ImageFile("张无忌.gif"));

        Folder txtFolder = new Folder("文本文件");
        txtFolder.add(new TextFile("九阴真经.txt"));
        txtFolder.add(new TextFile("九阳真经.doc"));

        Folder videoFolder = new Folder("视频文件");
        videoFolder.add(new VideoFile("笑傲江湖.rmvb"));

        Folder infosFolder = new Folder("Sunny的资料");
        infosFolder.add(imageFolder);
        infosFolder.add(txtFolder);
        infosFolder.add(videoFolder);
        infosFolder.killVirus();
    }
}

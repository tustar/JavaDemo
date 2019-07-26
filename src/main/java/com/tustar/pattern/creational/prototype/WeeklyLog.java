package com.tustar.pattern.creational.prototype;

import java.io.*;

public class WeeklyLog implements Serializable {

    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public WeeklyLog clone() {
        Object object;
        try {
            object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
            return null;
        }
    }

    public WeeklyLog deepClone() {
        try {
            // 将对象写入流中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将对象从流中取出
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (WeeklyLog)ois.readObject();
        } catch (Exception e) {
            System.out.println("克隆失败");
            return null;
        }
    }
}

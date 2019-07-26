package com.tustar.pattern.creational.prototype;

public class Client {
    public static void main(String[] args) {
        WeeklyLog oldLog, newLog;
        oldLog = new WeeklyLog();
        Attachment attachment = new Attachment();
        oldLog.setAttachment(attachment);
        //
        newLog = oldLog.deepClone();
        // 比较周报
        System.out.println("周报是否相同?" + (oldLog == newLog));
        // 比较附件
        System.out.println("附件是否相同?" + (oldLog.getAttachment() == newLog.getAttachment()));
    }
}

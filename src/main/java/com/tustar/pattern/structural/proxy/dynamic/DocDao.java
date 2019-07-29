package com.tustar.pattern.structural.proxy.dynamic;

public class DocDao implements IDocDao {
    @Override
    public Boolean deleteById(String documentId) {
        if (documentId.equalsIgnoreCase("D001")) {
            System.out.println("删除ID为" + documentId + "的文档信息成功！");
            return true;
        } else {
            System.out.println("删除ID为" + documentId + "的文档信息失败！");
            return false;
        }
    }
}

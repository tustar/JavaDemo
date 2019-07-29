package com.tustar.pattern.behavioral.cor;

public class Client {

    public static void main(String[] args) {
        Director zwj = new Director("张无忌");
        Manager hr = new Manager("黄蓉");
        VicePresident yg = new VicePresident("杨过");
        President gj = new President("郭靖");
        Congress dsh = new Congress("董事会");

        zwj.superior = hr;
        hr.superior = yg;
        yg.superior = gj;
        gj.superior = dsh;

        PurchaseRequest request1 = new PurchaseRequest(45_000, 10001, "购买倚天剑");
        zwj.doRequest(request1);

        PurchaseRequest request2 = new PurchaseRequest(60_000, 10002, "购买<<葵花宝典>>");
        zwj.doRequest(request2);

        PurchaseRequest request3 = new PurchaseRequest(160_000, 10003, "购买<<金刚经>>");
        zwj.doRequest(request3);

        PurchaseRequest request4 = new PurchaseRequest(800_000, 10004, "购买桃花岛");
        zwj.doRequest(request4);
    }
}

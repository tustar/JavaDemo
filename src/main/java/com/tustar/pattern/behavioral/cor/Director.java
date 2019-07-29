package com.tustar.pattern.behavioral.cor;

public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void doRequest(PurchaseRequest request) {
        if (request.getAmount() < 50_000) {
            System.out.println("主任" + name + "审批了" + request);
        } else {
            superior.doRequest(request);
        }
    }
}

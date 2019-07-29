package com.tustar.pattern.behavioral.cor;

public class Manager extends Approver {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void doRequest(PurchaseRequest request) {
        if (request.getAmount() < 80_000) {
            System.out.println("经理" + name + "审批了" + request);
        } else {
            superior.doRequest(request);
        }
    }
}

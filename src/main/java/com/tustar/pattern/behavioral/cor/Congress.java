package com.tustar.pattern.behavioral.cor;

public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void doRequest(PurchaseRequest request) {
        System.out.println("召开董事会，" + "审批了" + request);
    }
}

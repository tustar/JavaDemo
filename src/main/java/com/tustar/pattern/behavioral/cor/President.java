package com.tustar.pattern.behavioral.cor;

public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void doRequest(PurchaseRequest request) {
        if (request.getAmount() < 500_000) {
            System.out.println("董事长" + name + "审批了" + request);
        } else {
            superior.doRequest(request);
        }
    }
}

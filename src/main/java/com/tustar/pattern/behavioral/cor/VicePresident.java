package com.tustar.pattern.behavioral.cor;

public class VicePresident extends Approver {

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void doRequest(PurchaseRequest request) {
        if (request.getAmount() < 100_000) {
            System.out.println("副董事长" + name + "审批了" + request);
        } else {
            superior.doRequest(request);
        }
    }
}

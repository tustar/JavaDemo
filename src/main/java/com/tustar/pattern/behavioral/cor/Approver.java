package com.tustar.pattern.behavioral.cor;

public abstract class Approver {
    protected Approver superior;
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setSuperior(Approver superior) {
        this.superior = superior;
    }

    public abstract void doRequest(PurchaseRequest request);
}

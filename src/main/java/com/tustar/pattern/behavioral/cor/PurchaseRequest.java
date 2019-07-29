package com.tustar.pattern.behavioral.cor;

public class PurchaseRequest {

    private double amount;
    private int number;
    private String purpose;

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "采购单#"
                + "编号:" + number
                + ", 金额:" + amount + "元"
                + ", 目的:" + purpose + ".";
    }
}

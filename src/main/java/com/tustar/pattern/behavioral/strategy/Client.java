package com.tustar.pattern.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        double originalPrice = 60.0;
        double discountPrice;

        ticket.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("----------------");

        Discount discount = new StudentDiscount();
        ticket.setDiscount(discount);
        discountPrice = ticket.getPrice();

        System.out.println("折后价为:" + discountPrice);
    }
}

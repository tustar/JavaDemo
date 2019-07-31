package com.tustar.pattern.behavioral.tm;

public class CurrentCount extends Account {
    @Override
    public void calculateInterest() {
        System.out.println("按活期利率计算利息!");
    }
}

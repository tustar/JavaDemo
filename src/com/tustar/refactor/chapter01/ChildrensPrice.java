package com.tustar.refactor.chapter01;

/**
 * Created by tustar on 8/16/15.
 */
public class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}

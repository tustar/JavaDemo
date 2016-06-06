package com.tustar.refactor.chapter01;

/**
 * Created by tustar on 8/16/15.
 */
abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRencted) {
        return 1;
    }
}

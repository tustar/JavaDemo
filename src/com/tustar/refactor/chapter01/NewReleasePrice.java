package com.tustar.refactor.chapter01;

/**
 * Created by tustar on 8/16/15.
 */
public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRencted) {
        return daysRencted > 1 ? 2 : 1;
    }
}

package com.tustar.refactor.chapter01;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by tustar on 8/16/15.
 */
public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String statement() {

        Enumeration elements = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter pointers";
        return result;
    }

    public String htmlStatement() {

        Enumeration elements = rentals.elements();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n";
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
        }

        // add footer lines
        result += "<p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
        result += "On this rental you earned <em>" + String.valueOf(getTotalFrequentRenterPoints())
                + "</em> frequent renter pointers<p>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}

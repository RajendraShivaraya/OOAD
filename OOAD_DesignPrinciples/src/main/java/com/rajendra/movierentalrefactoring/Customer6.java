package com.rajendra.movierentalrefactoring;

//Renaimng the variables
import java.util.Enumeration;
import java.util.Vector;

public class Customer6 {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer6(String name) {
        _name = name;
    }


    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }


    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental2 each = (Rental2) rentals.nextElement();
// add frequent renter points
            frequentRenterPoints ++;
// add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    &&
                    each.getDaysRented() > 1) frequentRenterPoints ++;
//show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf
                            (each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
//add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +
                "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }



    private double amountFor(Rental2 aRental) {
        return aRental.getCharge();
    }
}

//The next step is to do a similar thing for the frequent renter points. The rules vary with the tape,
//although there is less variation than with charging. It seems reasonable to put the responsibility
//on the rental. First we need to use Extract Method on the frequent renter points part of the code









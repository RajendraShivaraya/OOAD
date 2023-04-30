package com.rajendra.movierentalrefactoring;

//Renaimng the variables
import java.util.Enumeration;
import java.util.Vector;

public class Customer4 {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer4(String name) {
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
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = amountFor(each);
// add frequent renter points
            frequentRenterPoints ++;
// add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints ++;
//show figures for this rental

            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
//add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +
                "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }

    private double amountFor(Rental aRental) {
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2)
                    result += (aRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (aRental.getDaysRented() > 3)
                    result += (aRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }
}


//As I look at amountFor, I can see that it uses information from the rental, but does not use
//information from the customer. This immediately raises my suspicions that the method is on the wrong object. In most cases a
//method should be on the object whose data it uses, thus the method should be moved to the
//rental. To do this I use Move Method. With this you first copy the code over to rental, adjust it to
//fit in its new home, we rename it to  getCharge(). we also change customer to use this mew method. In this case fitting into its new home means removing the parameter.

//The next step is to find every reference to the old method and adjust the reference to use the new
//method. replace amountFor with getCharge

//Sometimes I leave the old method to delegate to the new method. This is useful if it is a public
//method and I don't want to change the interface of the other class.
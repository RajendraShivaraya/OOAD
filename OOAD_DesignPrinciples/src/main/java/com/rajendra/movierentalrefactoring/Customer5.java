package com.rajendra.movierentalrefactoring;

//Renaimng the variables
import java.util.Enumeration;
import java.util.Vector;

public class Customer5 {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer5(String name) {
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
            Rental2 each = (Rental2) rentals.nextElement();
            thisAmount = each.getCharge();
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


    private double amountFor(Rental2 aRental) {
        return aRental.getCharge();
    }
}

//The next thing that strikes me is that thisAmount is now redundant. It is set to the result of
//each.charge and not changed afterward. Thus I can eliminate thisAmount by using Replace
//Temp with Query

//    I like to get rid of temporary variables such as this as much as possible. Temps are often a
//        problem in that they cause a lot of parameters to be passed around when they don't have to be.
//        You can easily lose track of what they are there for. They are particularly insidious in long
//        methods. Of course there is a performance price to pay; here the charge is now calculated twice.
//        But it is easy to optimize that in the rental class, and you can optimize much more effectively
//        when the code is properly factored.



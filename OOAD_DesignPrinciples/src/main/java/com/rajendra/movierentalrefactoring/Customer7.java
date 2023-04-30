package com.rajendra.movierentalrefactoring;

//Renaimng the variables
import java.util.Enumeration;
import java.util.Vector;

public class Customer7 {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer7(String name) {
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
            Rental3 each = (Rental3) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
//show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
//add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +
                "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                +
                " frequent renter points";
        return result;
    }




    private double amountFor(Rental2 aRental) {
        return aRental.getCharge();
    }
}



//As I suggested before, temporary variables can be a problem. They are useful only within their
//own routine, and thus they encourage long, complex routines. In this case we have two
//temporary variables, both of which are being used to get a total from the rentals attached to the
//customer. Both the ASCII and HTML versions require these totals. I like to use Replace Temp
//with Query to replace totalAmount and frequentRentalPoints with query methods.
//Queries are accessible to any method in the class and thus encourage a cleaner design without
//long, complex methods

// we will create the getTotalCharge() and getTotalFrequentRenterPoints() methods







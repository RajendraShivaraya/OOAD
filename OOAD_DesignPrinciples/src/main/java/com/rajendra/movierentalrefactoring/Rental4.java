package com.rajendra.movierentalrefactoring;
class Rental4 {
    private Movie2 _movie;
    private int _daysRented;

    public Rental4(Movie2 movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie2 getMovie() {
        return _movie;
    }

    int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }


    double getCharge() {
        return _movie.getCharge(_daysRented);
    }


}
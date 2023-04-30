package com.rajendra.blochbuilder;
import java.time.Year;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final Year published;
    private final String description;
    public Book(String isbn, String title, String author, Year published, String description) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;

    }
    public String getTitle() {

        return title;
    }


    public String getAuthor() {
        return author;
    }

    public Year getPublished() {
        return published;
    }

    public String getDescription() {
        return description;
    }

}
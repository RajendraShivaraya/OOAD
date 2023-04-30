package com.rajendra.blochbuilder;

import java.time.Year;

public class Demo {




    public static void main(String [] args){

        BookUsingBlochBuilder book1 = new BookUsingBlochBuilder.Builder("0-12-345678-9", "Moby-Dick")
                .author("Herman Melville")
                .published(Year.of(1851))
                .build();

        BookUsingBlochBuilder book2 = new BookUsingBlochBuilder.Builder("0-12-345678-9", "Moby-Dick")
                .author("Herman Melville")
                .published(Year.of(1851))
                .description(
                        "The book is the sailor Ishmael's narrative of the obsessive quest of "
                                + "Ahab, captain of the whaling ship Pequod, for revenge on Moby Dick, "
                                + "the giant white sperm whale that on the ship's previous voyage bit "
                                + "off Ahab's leg at the knee."
                )
                .build();
    }

}

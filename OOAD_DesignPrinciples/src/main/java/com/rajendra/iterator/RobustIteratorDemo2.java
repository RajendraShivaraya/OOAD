package com.rajendra.iterator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobustIteratorDemo2 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList("John", "Robert",
                "Alice", "Jamie", "Ben", "Ryan"));

        java.util.Iterator<String> namesIter = names.iterator();
        while (namesIter.hasNext()) {
            String s = (String) namesIter.next();
            System.out.println(s);

            if ("Alice".equals(s)) {
                namesIter.remove();
            }
        }
        System.out.println("******************");
        java.util.Iterator<String> namesIter2 = names.iterator();
        while (namesIter2.hasNext()) {
            String s = (String) namesIter2.next();
            System.out.println(s);

        }


        java.util.Iterator<String> namesIter3 = names.iterator();
        while (namesIter3.hasNext()) {
            String s = (String) namesIter3.next();
            System.out.println(s);

            if ("Jamie".equals(s)) {
                names.remove("Jamie");
            }
        }
    }
}
package com.rajendra.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InternalIterator {

    public static void main(String[] args) {

        List<String> words = List.of("hello", "sky", "there", "den", "sky");

        words.stream().forEach(e ->
                System.out.printf("The word %s has %d characters \n", e, e.length()));

    }
}
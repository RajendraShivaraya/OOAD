package com.rajendra.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobustIteratorDemo {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>(Arrays.asList("John", "Robert",
                "Alice", "Jamie", "Ben", "Ryan"));

        for (String word: words) {

            if ("Alice".equals(word)) {

                words.remove(word);
            }
        }

        System.out.println(words);
    }
}
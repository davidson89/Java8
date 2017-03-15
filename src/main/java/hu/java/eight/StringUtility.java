package hu.java.eight;

import java.util.List;

import static java.util.Comparator.comparing;

public class StringUtility {
    public List<String> sortStringsByLength(List<String> list) {
        // Pass method as parameter (Java 8)
        list.sort(comparing(String::length));

        return list;
    }
}

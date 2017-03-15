package hu.java.eight;

import java.util.List;

import static java.util.Comparator.comparing;

public class StringUtils {
    public static List<String> sortStringsByLength(List<String> unsortedList) {

        unsortedList.sort(comparing(String::length));

        return unsortedList;
    }
}

package hu.java.eight;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StringUtility {

    // Pass method as parameter in Java 8
    public List<String> sortStringsByLength(List<String> list) {
        list.sort(comparing(String::length));

        return list;
    }

    // Multi-thread filtering in Java 8
    public List<String> filterHigherThan(int lowerLengthBound, List<String> input) {
        return input.parallelStream()
                .filter((String word) -> word.length() > lowerLengthBound)
                .collect(toList());
    }
}

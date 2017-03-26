package hu.java.eight;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class NumberPairing extends StringUtility {
    public List<Integer[]> pairNumbers(List<Integer> numbers, List<Integer> otherNumbers) {
        return numbers.stream()
                .flatMap(i -> otherNumbers.stream()
                        .map(j -> new Integer[]{i, j}))
                .collect(toList());
    }
}

package hu.java.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
    public List<int[]> generatePythagoreanTriples(int limit) {
        List<int[]> result = new ArrayList<>();

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1.0 == 0)
                        .map(t -> new int[]{(int) t[0], (int) t[1], (int) t[2]})
                );

        pythagoreanTriples.limit(limit)
                .forEach(triple -> result.add(triple));

        return result;
    }
}

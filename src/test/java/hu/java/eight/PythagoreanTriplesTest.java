package hu.java.eight;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public final class PythagoreanTriplesTest {

    private final PythagoreanTriples underTest;

    public PythagoreanTriplesTest() {
        this.underTest = new PythagoreanTriples();
    }

    @Test
    public void shouldGeneratePythagoreanTriples() {
        final List<int[]> expectedResult = Arrays.asList(
                new int[]{3, 4, 5},
                new int[]{5, 12, 13},
                new int[]{6, 8, 10},
                new int[]{7, 24, 25},
                new int[]{8, 15, 17}
        );

        final List<int[]> actualResult = underTest.generatePythagoreanTriples(5);

        assertEquals(actualResult.size(), expectedResult.size());

        for (int i = 0; i < actualResult.size(); i++) {
            assertEquals(actualResult.get(i)[0], expectedResult.get(i)[0]);
            assertEquals(actualResult.get(i)[1], expectedResult.get(i)[1]);
            assertEquals(actualResult.get(i)[2], expectedResult.get(i)[2]);
        }
    }
}

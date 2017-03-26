package hu.java.eight;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NumberPairingTest {

    private NumberPairing underTest;

    public NumberPairingTest() {
        underTest = new NumberPairing();
    }

    @Test
    public void shouldPairNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> otherNumbers = Arrays.asList(4, 5);

        List<Integer[]> expectedResult = Arrays.asList(
                new Integer[]{1, 4},
                new Integer[]{1, 5},
                new Integer[]{2, 4},
                new Integer[]{2, 5},
                new Integer[]{3, 4},
                new Integer[]{3, 5}
        );

        List<Integer[]> actualResult = underTest.pairNumbers(numbers, otherNumbers);

        assertEquals(actualResult.size(), expectedResult.size());

        for (int i = 0; i < actualResult.size(); i++) {
            assertTrue(Arrays.deepEquals(actualResult.get(i), expectedResult.get(i)));
        }
    }
}

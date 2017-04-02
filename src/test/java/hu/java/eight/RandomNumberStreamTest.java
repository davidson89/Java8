package hu.java.eight;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public final class RandomNumberStreamTest {
    private final RandomNumberStream underTest;

    public RandomNumberStreamTest() {
        this.underTest = new RandomNumberStream();
    }

    @Test
    public void shouldGenerateFiveRandomNumbers() {
        List<Double> actualOutput = underTest.generateFiveRandomNumbers();
        actualOutput.forEach(i -> assertTrue(i >= 0 && i <= 1));
    }
}

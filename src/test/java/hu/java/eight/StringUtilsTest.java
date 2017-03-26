package hu.java.eight;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StringUtilsTest {

    private StringUtility underTest;

    public StringUtilsTest() {
        underTest = new StringUtility();
    }

    @Test
    public void shouldSortListOfStringsByLength() {
        List<String> input = Arrays.asList("Cseresznye", "Alma", "Korte");
        List<String> expectedOutput = Arrays.asList("Alma", "Korte", "Cseresznye");

        List<String> actualOutput = underTest.sortStringsByLength(input);

        assertTrue(actualOutput.equals(expectedOutput), "Should sort list by length of contained strings");
    }

    @Test
    public void shouldSortListOfStringsIgnoringCases() {
        List<String> input = Arrays.asList("cseresznye", "Alma", "Korte");
        List<String> expectedOutput = Arrays.asList("Alma", "cseresznye", "Korte");

        List<String> actualOutput = underTest.sortStringsIgnoringCases(input);

        assertTrue(actualOutput.equals(expectedOutput), "Should sort list of strings ignoring cases");
    }

    @Test
    public void shouldSortListOfStringsUsingNaturalComparator() {
        List<String> input = Arrays.asList("cseresznye", "Korte", "alma");
        List<String> expectedOutput = Arrays.asList("Korte", "alma", "cseresznye");

        List<String> actualOutput = underTest.sortStringsWithNaturalComparator(input);

        assertTrue(actualOutput.equals(expectedOutput), "Should sort list of strings by natural order");
    }

    @Test
    public void shouldFilterListOfStrings() {
        List<String> input = Arrays.asList("Cseresznye", "Alma", "Korte");
        List<String> expectedOutput = Arrays.asList("Cseresznye");
        int lowerLengthBound = 5;

        List<String> actualOutput = underTest.filterHigherThan(lowerLengthBound, input);

        assertTrue(actualOutput.equals(expectedOutput), "Should filter elements shorter or long as the bound");
    }

    @Test
    public void shouldSumLengthOfStrings() {
        List<String> input = Arrays.asList("Cseresznye", "Alma", "Korte");
        int expectedOutput = 19;

        int actualOutput = underTest.sumLengthOfStrings(input);

        assertEquals(actualOutput, expectedOutput, "Should filter elements shorter or long as the bound");
    }
}

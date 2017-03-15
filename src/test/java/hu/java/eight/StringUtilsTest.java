package hu.java.eight;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
}

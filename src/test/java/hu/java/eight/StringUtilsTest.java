package hu.java.eight;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class StringUtilsTest {
    @Test
    public void shouldSortListOfStringsByLength() {
        List<String> input = Arrays.asList("Cseresznye", "Alma", "Korte");
        List<String> output = StringUtils.sortStringsByLength(input);
        List<String> expectedOutput = Arrays.asList("Alma", "Korte", "Cseresznye");

        assertTrue(output.equals(expectedOutput), "Should sort list of strings");
    }
}

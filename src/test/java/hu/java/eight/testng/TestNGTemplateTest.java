package hu.java.eight.testng;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public final class TestNGTemplateTest {

    private final MagicClass underTest;

    public TestNGTemplateTest() {
        underTest = new MagicClass();
    }

    @Test
    public void testMagicFunctionality() {
        final String magicString = "Magic!";
        final int expectedLength = 6;

        final int actualLength = underTest.magicFunction(magicString);

        assertEquals("Magic test", expectedLength, actualLength);
    }
}

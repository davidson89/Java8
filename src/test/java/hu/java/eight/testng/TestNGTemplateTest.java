package hu.java.eight.testng;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestNGTemplateTest {

    private MagicClass underTest;

    public TestNGTemplateTest() {
        underTest = new MagicClass();
    }

    @Test
    public void testMagicFunctionality() {
        String magicString = "Magic!";

        int output = underTest.magicFunction(magicString);

        assertEquals("Magic test", 6, output);
    }
}

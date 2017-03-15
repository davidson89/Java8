package hu.java.eight.testng;

import org.testng.annotations.Test;

public class TestNGTemplateTest {
    @Test
    public void testMagicFunctionality() {
        String magic = "Magic!";
        assert "Magic!".equals(magic);
    }
}

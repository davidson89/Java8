package hu.java.eight;

import org.testng.annotations.Test;

public final class CompletableFuturesExampleTest {
    private final CompletableFuturesExample underTest;

    public CompletableFuturesExampleTest() {
        this.underTest = new CompletableFuturesExample();
    }

    @Test
    public void shouldTest() {
        underTest.magic();
    }
}

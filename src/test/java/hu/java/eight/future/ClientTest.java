package hu.java.eight.future;

import org.testng.annotations.Test;

import java.text.MessageFormat;

public final class ClientTest {
    private final Client underTest;

    public ClientTest() {
        this.underTest = new Client();
    }

    @Test
    public void shouldTest() {
        underTest.magic();
    }

    @Test
    public void shouldFindPrices() {
        final long start = System.nanoTime();

        System.out.println(underTest.findPrices("MyPhone27s"));

        final int million = 1_000_000;
        final long duration = ((System.nanoTime() - start) / million);
        System.out.println(MessageFormat.format("Done in {0} ms", duration));
    }
}

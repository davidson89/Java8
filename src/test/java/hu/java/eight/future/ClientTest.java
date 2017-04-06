package hu.java.eight.future;

import org.testng.annotations.Test;

public final class ClientTest {
    private final Client underTest;

    public ClientTest() {
        this.underTest = new Client();
    }

    @Test
    public void shouldTest() {
        underTest.magic();
    }
}

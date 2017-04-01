package hu.java.eight;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public final class FileStreamTest {

    private static final String FILE_NAME = "/data.txt";

    private final FileStream underTest;

    public FileStreamTest() {
        this.underTest = new FileStream();
    }

    @Test
    public void shouldCountUniqueWordsFromFile() throws IOException, URISyntaxException {
        final long expectedResult = 3L;
        final long actualResult = underTest.countUniquesWordsFromFile(FILE_NAME);

        assertEquals(actualResult, expectedResult);
    }
}

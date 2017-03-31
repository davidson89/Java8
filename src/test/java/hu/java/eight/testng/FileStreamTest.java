package hu.java.eight.testng;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public class FileStreamTest {

    private static final String FILE_NAME = "/data.txt";

    private FileStream underTest;

    public FileStreamTest() {
        this.underTest = new FileStream();
    }

    @Test
    public void shouldCountUniqueWordsFromFile() throws IOException, URISyntaxException {
        long expectedResult = 3L;
        long actualResult = underTest.countUniquesWordsFromFile(FILE_NAME);

        assertEquals(actualResult, expectedResult);
    }
}

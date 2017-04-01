package hu.java.eight;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

public final class FileStream {
    private static final Logger LOGGER = Logger.getLogger(FileStream.class.getName());
    private static final String SEPARATOR = " ";

    public long countUniquesWordsFromFile(final String fileName) throws URISyntaxException, IOException {
        final URI fileUri = FileStream.class.getResource(fileName).toURI();

        // try-with-resources statement
        try (Stream<String> lines = Files.lines(Paths.get(fileUri), Charset.defaultCharset())) {
            return lines
                    .flatMap(line -> Arrays.stream(line.split(SEPARATOR)))
                    .distinct()
                    .count();
        } catch (IOException e) {
            LOGGER.severe(MessageFormat.format("Could not find file: {0}", fileName));
            throw e;
        }
    }
}

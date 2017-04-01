package hu.java.eight;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

final class FileStream {
    private static final Logger LOGGER = Logger.getLogger(FileStream.class.getName());
    private static final String SEPARATOR = "\\s+";

    public long countUniquesWordsFromFile(final String fileName) throws URISyntaxException, IOException {
        final URL url = FileStream.class.getResource(fileName);

        if (url == null) {
            LOGGER.severe(MessageFormat.format("Could not find file: {0}", fileName));
            throw new IOException(MessageFormat.format("Could not find file: {0}", fileName));
        }

        final URI fileUri = url.toURI();

        // try-with-resources statement
        try (Stream<String> lines = Files.lines(Paths.get(fileUri), Charset.defaultCharset())) {
            return lines
                    .flatMap(line -> Arrays.stream(line.split(SEPARATOR)))
                    .distinct()
                    .count();
        }
    }
}

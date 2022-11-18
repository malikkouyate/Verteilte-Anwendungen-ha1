package de.berlin.htw.control.producer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

/**
 * @author Alexander Stanik [stanik@htw-berlin.de]
 */
@Singleton
public class FileStreamProducer {

    @Inject
    Logger logger;

    @Default
    @Produces
    public OutputStream getStream() {
        return stream;
    }

    private OutputStream stream;

    @PostConstruct
    void openStream() throws IOException {
        Path temp = Files.createTempFile("va", ".file");
        logger.info("Writing plain text to " + temp);
        stream = Files.newOutputStream(temp);
    }

    @PreDestroy
    void closeStream() throws IOException {
        stream.close();
    }
}

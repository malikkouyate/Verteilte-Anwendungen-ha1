package de.berlin.htw.control.producer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipOutputStream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import de.berlin.htw.control.qualifier.Zipped;

/**
 * @author Alexander Stanik [stanik@htw-berlin.de]
 */
@Singleton
public class ZippedFileStreamProducer {

    @Inject
    Logger logger;

    @Zipped
    @Produces
    public OutputStream getStream() {
        return stream;
    }

    private ZipOutputStream stream;

    @PostConstruct
    void openStream() throws IOException {
        Path temp = Files.createTempFile("va", ".zip");
        logger.info("Writing plain text to " + temp);
        stream = new ZipOutputStream(Files.newOutputStream(temp));
    }

    @PreDestroy
    void closeStream() throws IOException {
        stream.close();
    }
}

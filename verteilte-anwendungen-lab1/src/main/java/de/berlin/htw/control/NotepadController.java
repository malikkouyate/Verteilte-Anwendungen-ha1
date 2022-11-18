package de.berlin.htw.control;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;

import de.berlin.htw.control.qualifier.GZipped;

/**
 * @author Alexander Stanik [stanik@htw-berlin.de]
 */
@RequestScoped
public class NotepadController {

    @Inject
    @GZipped
    OutputStream stream;

    GreetingService service;

    @Inject
    NotepadController(GreetingService service) {
        super();
        this.service = service;
    }

    public void writeReminder(final Principal userPrincipal, final String reminder) {
        final String text = service.getGeeting(userPrincipal) + reminder;
        try {
            stream.write(text.getBytes());
            stream.flush();
        } catch (IOException e) {
            throw new InternalServerErrorException("Unable to write text.", e);
        }
    }

}

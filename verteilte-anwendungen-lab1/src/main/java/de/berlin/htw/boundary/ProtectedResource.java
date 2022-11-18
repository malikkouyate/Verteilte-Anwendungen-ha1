package de.berlin.htw.boundary;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import de.berlin.htw.control.GreetingService;
import de.berlin.htw.control.NotepadController;

/**
 * @author Alexander Stanik [stanik@htw-berlin.de]
 */
@Path("/protected")
public class ProtectedResource {

    @Context
    UriInfo uri;
    
    @Inject
    GreetingService service;

    @Inject
    NotepadController controller;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSecretInformation(@Context final SecurityContext sec) {
        final String greeting = service.getGeeting(sec.getUserPrincipal());
        if (sec.isSecure() && sec.isUserInRole("ADMIN")) {
            return Response.ok(greeting + "you are accessing " + uri.getPath())
                .build();
        } else {
            throw new ForbiddenException("You don't have admin privileges!");
        }
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void addReminder(@Context final SecurityContext sec, final String reminder) {
        controller.writeReminder(sec.getUserPrincipal(), reminder);
    }

}
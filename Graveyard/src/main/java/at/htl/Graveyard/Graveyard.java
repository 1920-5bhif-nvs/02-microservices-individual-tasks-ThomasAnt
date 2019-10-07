package at.htl.Graveyard;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.json.JsonArray;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/grave")
public class Graveyard {
    @Inject
    @RestClient
    GraveyardService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGraveyards(){
        return Response.ok().entity(service.getGraves()).build();
    }
}

package at.htl.Graveyard;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.json.JsonArray;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/graveyards")
public class Graveyard {
    @Inject
    @RestClient
    GraveyardService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public Response getGraveyards(){
        return Response.ok().entity(service.getGraves()).build();
    }
}

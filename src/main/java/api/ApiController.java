package api;

import instagram.JsonDataProcessor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/instagram")
public class ApiController {

    public JsonDataProcessor jsonDataProcessor = new JsonDataProcessor();

    @GET
    @Path("/followrequestssent")
    @Produces(MediaType.APPLICATION_JSON)
    public String FollowRequestsPending() {
        String response = "No data found";
        response = jsonDataProcessor.getConnections("follow_requests_sent").toString();
        return response;
    }

    @GET
    @Path("/whonotfollowme")
    @Produces(MediaType.APPLICATION_JSON)
    public String DifferenceInConnections() {
        String response = "No data found";
        response = jsonDataProcessor.getDifference();
        return response;
    }

    @GET
    @Path("/followingme")
    @Produces(MediaType.APPLICATION_JSON)
    public String FollowingUsers() {
        String response = "No data found";
        response = jsonDataProcessor.getConnections("following").toString();
        return response;
    }
}

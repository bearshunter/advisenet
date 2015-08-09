package com.prokopenkodi.advisenet.api;

import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.classes.response.GetUserResponse;
import com.prokopenkodi.advisenet.entity.User;

import javax.ws.rs.*;

@Path("/user")
@Produces({"text/plain", "application/json"})
@Consumes("application/json")
public interface UserAdapter {
    @GET
    @Path("{userID}")
    GetUserResponse get(@PathParam("userID") Long userId);


    @GET
    @Path("email/{email}")
    GetUserResponse getByEmail(@PathParam("email") String email);

    @PUT
    ErrorData save(User user);

    @POST
    ErrorData update(User user);

    @DELETE
    @Path("{userID}")
    ErrorData delete(@PathParam("userID") Long userId);
}

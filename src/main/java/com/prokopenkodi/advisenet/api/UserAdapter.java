package com.prokopenkodi.advisenet.api;

import com.prokopenkodi.advisenet.classes.exception.AdvisenetException;
import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.entity.User;

import javax.ws.rs.*;

@Path("/user")
@Produces({"text/plain", "application/json"})
@Consumes("application/json")
public interface UserAdapter {
    @GET
    @Path("{userID}")
    User get(@PathParam("userID") Long userId) throws AdvisenetException;


    @GET
    @Path("email/{email}")
    User getByEmail(@PathParam("email") String email) throws AdvisenetException;

    @PUT
    ErrorData save(User user);

    @POST
    ErrorData update(User user);

    @DELETE
    @Path("{userID}")
    ErrorData delete(@PathParam("userID") Long userId);
}

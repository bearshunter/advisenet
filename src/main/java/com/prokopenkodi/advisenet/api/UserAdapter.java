package com.prokopenkodi.advisenet.api;

import com.prokopenkodi.advisenet.classes.response.BaseResponse;
import com.prokopenkodi.advisenet.classes.response.GetUserResponse;
import com.prokopenkodi.advisenet.entity.User;

import javax.ws.rs.*;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public interface UserAdapter {
    @GET
    @Path("{userID}")
    GetUserResponse get(@PathParam("userID") Long userId);

    @GET
    @Path("email/{email}")
    GetUserResponse getByEmail(@PathParam("email") String email);

    @PUT
    BaseResponse save(User user);

    @POST
    BaseResponse update(User user);

    @DELETE
    @Path("{userID}")
    BaseResponse delete(@PathParam("userID") Long userId);
}

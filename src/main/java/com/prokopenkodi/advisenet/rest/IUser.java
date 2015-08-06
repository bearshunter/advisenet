package com.prokopenkodi.advisenet.rest;

import com.prokopenkodi.advisenet.entity.User;
import com.prokopenkodi.advisenet.rest.result.ErrorData;

import javax.ws.rs.*;

public interface IUser {


    @GET
    @Path("{userID}")
    User get(@PathParam("userID") Long userId);

    @PUT
    ErrorData add(User user);

    @POST
    ErrorData update(User user);

    @DELETE
    @Path("{userID}")
    ErrorData delete(@PathParam("userID") Long userId);

    @GET
    @Path("ping")
    String ping();
}
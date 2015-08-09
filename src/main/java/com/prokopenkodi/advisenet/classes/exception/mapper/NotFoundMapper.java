package com.prokopenkodi.advisenet.classes.exception.mapper;

import com.prokopenkodi.advisenet.classes.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity("Not found").build();
    }
}

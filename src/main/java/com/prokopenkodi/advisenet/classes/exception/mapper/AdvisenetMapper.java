package com.prokopenkodi.advisenet.classes.exception.mapper;

import com.prokopenkodi.advisenet.classes.exception.AdvisenetException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AdvisenetMapper implements ExceptionMapper<AdvisenetException> {
    @Override
    public Response toResponse(AdvisenetException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal error").build();
    }
}

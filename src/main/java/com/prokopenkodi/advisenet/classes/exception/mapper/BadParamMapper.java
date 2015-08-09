package com.prokopenkodi.advisenet.classes.exception.mapper;

import com.prokopenkodi.advisenet.classes.exception.BadParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class BadParamMapper implements ExceptionMapper<BadParamException> {

    @Override
      public Response toResponse(BadParamException e) {
        return Response.status(Response.Status.FORBIDDEN).entity("Bad param "+e.getMessage()).build();
    }
}


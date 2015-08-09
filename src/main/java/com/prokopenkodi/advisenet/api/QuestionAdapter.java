package com.prokopenkodi.advisenet.api;

import com.prokopenkodi.advisenet.classes.response.BaseResponse;
import com.prokopenkodi.advisenet.classes.response.GetOneQuestionResponse;
import com.prokopenkodi.advisenet.classes.response.GetQuestionTypesResponse;
import com.prokopenkodi.advisenet.classes.response.GetQuestionsResponse;
import com.prokopenkodi.advisenet.entity.Question;

import javax.ws.rs.*;

@Path("question")
@Produces("application/json")
@Consumes("application/json")
public interface QuestionAdapter {

    @GET
    @Path("{id}")
    GetOneQuestionResponse get(@PathParam("id") Long questionId);


    @GET
    @Path("opened")
    GetQuestionsResponse findAllOpened();

    @GET
    @Path("types")
    GetQuestionTypesResponse getAllTypes();

    @GET
    @Path("status/{id}/closed")
    GetOneQuestionResponse setClosedStatusToQuestion(@PathParam("id") Long questionId);

    @GET
    @Path("status/{id}/opened")
    GetOneQuestionResponse setOpenedStatusToQuestion(@PathParam("id") Long questionId);

    @PUT
    BaseResponse create(Question question);

    @POST
    BaseResponse update(Question question);

    @DELETE
    BaseResponse delete(Long id);

}

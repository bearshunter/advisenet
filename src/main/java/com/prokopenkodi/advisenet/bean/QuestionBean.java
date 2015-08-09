package com.prokopenkodi.advisenet.bean;

import com.prokopenkodi.advisenet.api.QuestionAdapter;
import com.prokopenkodi.advisenet.classes.ErrorCode;
import com.prokopenkodi.advisenet.classes.Status;
import com.prokopenkodi.advisenet.classes.response.BaseResponse;
import com.prokopenkodi.advisenet.classes.response.GetOneQuestionResponse;
import com.prokopenkodi.advisenet.classes.response.GetQuestionTypesResponse;
import com.prokopenkodi.advisenet.classes.response.GetQuestionsResponse;
import com.prokopenkodi.advisenet.dao.QuestionDAO;
import com.prokopenkodi.advisenet.entity.Question;
import com.prokopenkodi.advisenet.entity.QuestionType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@SuppressWarnings("unused")
public class QuestionBean implements QuestionAdapter {

    @Inject
    private QuestionDAO dao;

    @Override
    public GetOneQuestionResponse get(Long questionId) {
        Question question = dao.getById(questionId);
        if (question != null) {
            return new GetOneQuestionResponse(question);
        }

        return new GetOneQuestionResponse(ErrorCode.NOT_FOUND);
    }

    @Override
    public GetQuestionsResponse findAllOpened() {
        List<Question> openedQuestionList = dao.findOpened();
        return new GetQuestionsResponse(openedQuestionList);
    }

    @Override
    public GetQuestionTypesResponse getAllTypes() {
        List<QuestionType> questionTypes = dao.getAllTypes();
        return new GetQuestionTypesResponse(questionTypes);
    }

    @Override
    public GetOneQuestionResponse setClosedStatusToQuestion(Long questionId) {
        return changeStatus(questionId, Status.CLOSED);
    }

    @Override
    public GetOneQuestionResponse setOpenedStatusToQuestion(Long questionId) {
        return changeStatus(questionId, Status.OPEN);
    }

    @Override
    public BaseResponse create(Question question) {
        if(dao.save(question)){
            return new BaseResponse();
        }
        return new BaseResponse(ErrorCode.INTERNAL_ERROR);
    }

    @Override
    public BaseResponse update(Question question) {
        if(dao.update(question)){
            return new BaseResponse();
        }
        return new BaseResponse(ErrorCode.INTERNAL_ERROR);
    }

    @Override
    public BaseResponse delete(Long id) {
        if(dao.delete(dao.getById(id))){
            return new BaseResponse();
        }
        return new BaseResponse(ErrorCode.INTERNAL_ERROR);
    }


    private GetOneQuestionResponse changeStatus(Long questionId, Status status) {
        Question question = dao.getById(questionId);
        if (question.getStatus().equals(status)) {
            return new GetOneQuestionResponse(question);
        }
        question.setStatus(status);
        if (dao.update(question)) {
            return new GetOneQuestionResponse(question);
        }
        return new GetOneQuestionResponse(ErrorCode.INTERNAL_ERROR);
    }
}

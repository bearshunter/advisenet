package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.entity.QuestionType;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
public class GetQuestionTypesResponse extends BaseResponse {
    private List<QuestionType> questionTypes;


    public GetQuestionTypesResponse(List<QuestionType> questionTypes) {
        super();
        this.questionTypes = questionTypes;
    }

    public GetQuestionTypesResponse(ErrorData errorData) {
        super(errorData);
    }
}
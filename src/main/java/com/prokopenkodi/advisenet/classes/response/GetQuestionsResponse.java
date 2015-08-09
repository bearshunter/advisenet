package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.entity.Question;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
public class GetQuestionsResponse  extends BaseResponse{

    private List<Question> questions;

    public GetQuestionsResponse(List<Question> questions) {
        super(new ErrorData());
        this.questions = questions;
    }

    public GetQuestionsResponse(ErrorData errorData) {
        super(errorData);
    }
}

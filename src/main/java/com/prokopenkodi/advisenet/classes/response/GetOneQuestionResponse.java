package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.entity.Question;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class GetOneQuestionResponse extends BaseResponse{

    private Question question;

    public GetOneQuestionResponse(int code) {
        super(new ErrorData(code));
    }

    public GetOneQuestionResponse(Question question) {
        super(new ErrorData());
        this.question = question;
    }

    public GetOneQuestionResponse(ErrorData errorData, Question question) {
        super(errorData);
        this.question = question;
    }
}

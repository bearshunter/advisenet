package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.entity.User;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class GetUserResponse {
    private ErrorData errorData;
    private User user;

    public GetUserResponse(ErrorData errorData, User user) {
        this.errorData = errorData;
        this.user = user;
    }

    public GetUserResponse(User user) {
        this.errorData = new ErrorData();
        this.user = user;
    }

    public GetUserResponse(ErrorData errorData) {
        this.errorData = new ErrorData();
    }
}

package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.entity.User;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class GetUserResponse extends BaseResponse{

    private User user;

    public GetUserResponse(ErrorData errorData, User user) {
        super(errorData);
        this.user = user;
    }

    public GetUserResponse(User user) {
        super(new ErrorData());
        this.user = user;
    }

    public GetUserResponse(ErrorData errorData) {
        super(new ErrorData());
    }
}

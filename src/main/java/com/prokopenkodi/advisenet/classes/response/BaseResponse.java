package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class BaseResponse {


    public BaseResponse() {
        this.errorData = new ErrorData();
    }

    public BaseResponse(int code) {
        this.errorData = new ErrorData(code);
    }

    public BaseResponse(ErrorData errorData) {
        this.errorData = errorData;
    }

    private ErrorData errorData;


}

package com.prokopenkodi.advisenet.classes.response;

import com.prokopenkodi.advisenet.classes.ErrorData;

import javax.xml.bind.annotation.XmlRootElement;


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

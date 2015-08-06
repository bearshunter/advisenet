package com.prokopenkodi.advisenet.rest.result;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class ErrorData {
    private int code;
    private String message;

    public ErrorData(){
        this.code = ErrorCode.SUCCESS;
        this.message = "OK";
    }

}

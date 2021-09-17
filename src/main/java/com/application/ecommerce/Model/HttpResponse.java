package com.application.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class HttpResponse {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String messageReason;
    private String messageContent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss",timezone = "Europe/Prague")
    private Date messageTimestamp;

    public HttpResponse(){}

    public HttpResponse(int httpStatusCode,HttpStatus httpStatus, String messageReason, String messageContent){
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.messageReason = messageReason;
        this.messageContent = messageContent;
        this.messageTimestamp = new Date();
    }



    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessageReason() {
        return messageReason;
    }

    public void setMessageReason(String messageReason) {
        this.messageReason = messageReason;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(Date messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }
}

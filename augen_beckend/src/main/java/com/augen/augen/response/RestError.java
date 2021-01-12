package com.augen.augen.response;

public class RestError {

    private String code;
    private int statusCode;
    private String message;
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getUserMessage() {
        return message;
    }
    public void setUserMessage(String userMessage) {
        this.message = userMessage;
    }
}

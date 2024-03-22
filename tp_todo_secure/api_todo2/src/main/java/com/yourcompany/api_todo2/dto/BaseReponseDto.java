package com.yourcompany.api_todo2.dto;

public class BaseReponseDto {

    private String message;
    private Object data;

    public BaseReponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public BaseReponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

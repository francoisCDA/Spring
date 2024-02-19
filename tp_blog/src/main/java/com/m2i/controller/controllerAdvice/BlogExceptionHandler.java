package com.m2i.controller.controllerAdvice;

import com.m2i.exception.UnknowPostId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BlogExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UnknowPostId.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUnknowPostId(UnknowPostId ex){
        return ex.getMessage();
    }



}

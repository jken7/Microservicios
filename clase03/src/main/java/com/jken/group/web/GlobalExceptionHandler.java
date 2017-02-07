package com.jken.group.web;

import com.jken.group.business.NotFoundExcpetion;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by root on 2/3/17.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExcpetion.class)
    public HttpEntity notFound(NotFoundExcpetion exp){
        return ResponseEntity.notFound().build();

    }
}

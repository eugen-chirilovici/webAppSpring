package com.springapp.mvc.exceptionsHandlers;

import org.springframework.http.HttpStatus;

public class CustomUserException extends Exception {
    private final HttpStatus responseCode;

    public CustomUserException(String mes, HttpStatus status) {
        super(mes);
        responseCode = status;
    }

    public HttpStatus getResponseCode() {return responseCode;}
}

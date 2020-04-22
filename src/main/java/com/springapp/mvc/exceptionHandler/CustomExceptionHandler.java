package com.springapp.mvc.exceptionHandler;

import org.springframework.http.HttpStatus;

public class CustomExceptionHandler extends Exception {
    private final HttpStatus responseCode;

    public CustomExceptionHandler(String message, HttpStatus code) {
        super(message);
        this.responseCode = code;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }
}

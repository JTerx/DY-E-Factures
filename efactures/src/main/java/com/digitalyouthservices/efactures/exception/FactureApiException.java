package com.digitalyouthservices.efactures.exception;

import org.springframework.http.HttpStatus;

public class FactureApiException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public FactureApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public FactureApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

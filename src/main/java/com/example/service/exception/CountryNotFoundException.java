package com.example.service.exception;

import org.springframework.web.ErrorResponse;

public class CountryNotFoundException extends RuntimeException{
        Throwable cause;
        private String message;

        ErrorResponse a;
    protected CountryNotFoundException(){}

    public CountryNotFoundException(String message){
        super();
        this.message=message;
    }
    public CountryNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

}

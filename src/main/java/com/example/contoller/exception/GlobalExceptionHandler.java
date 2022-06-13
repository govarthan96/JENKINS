package com.example.contoller.exception;

import com.example.domain.GlobalErrorResponse;
import com.example.service.exception.CountryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CountryNotFoundException.class)
    public final ResponseEntity<String> handleCountryNotFoundException(CountryNotFoundException ex){

        GlobalErrorResponse globalErrorResponse = GlobalErrorResponse.builder().httpStatus(HttpStatus.NOT_FOUND).timestamp(Timestamp.valueOf(LocalDateTime.now())).errorCode(600).errorMsg(ex.getMessage()==null?"Country Not Found":ex.getMessage()).build();
        return  new ResponseEntity(globalErrorResponse,HttpStatus.NOT_FOUND);
    }
}

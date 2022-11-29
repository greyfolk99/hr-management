package com.hrmanagement.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends CustomException{
    public DataNotFoundException(ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass, httpStatus, exceptionClass.toString() + message);
    }
}

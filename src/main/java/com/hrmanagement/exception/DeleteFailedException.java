package com.hrmanagement.exception;

import org.springframework.http.HttpStatus;

public class DeleteFailedException extends CustomException{
    public DeleteFailedException(ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass, httpStatus, exceptionClass.toString() + message);
    }
}

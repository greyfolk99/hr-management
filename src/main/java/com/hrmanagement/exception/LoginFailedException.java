package com.hrmanagement.exception;

import org.springframework.http.HttpStatus;

public class LoginFailedException extends CustomException{
    public LoginFailedException(ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass, httpStatus, exceptionClass.toString() + message);
    }
}

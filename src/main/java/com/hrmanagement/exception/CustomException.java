package com.hrmanagement.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {
    private ExceptionClass exceptionClass;
    private HttpStatus httpStatus;
    public CustomException(ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
            super(exceptionClass.toString() + message);
            this.exceptionClass = exceptionClass;
            this.httpStatus = httpStatus;
            }
    public ExceptionClass getExceptionClass(){ return exceptionClass; }
    public int getHttpStatusCode() { return httpStatus.value(); }
    public String getHttpStatusType(){ return httpStatus.getReasonPhrase(); }
    public HttpStatus getHttpStatus() { return httpStatus; }
}

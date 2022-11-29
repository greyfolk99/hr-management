package com.hrmanagement.exception;

public enum ExceptionClass {
    DEPARTMENT("dep"),
    USER("user"),
    EMPLOYEE("employee"),
    PERMISSION("perimission"),
    ROLE("role"),
    SALARY("salary"),
    TRAINING("training"),
    BANK_ACCOUNT("bank_account");

    private String exceptionClass;

    ExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public String getExceptionClass() {
        return exceptionClass;
    }

    @Override
    public String toString() {
        return getExceptionClass() + " related exception.";
    }
    }

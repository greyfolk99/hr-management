package com.hrmanagement.advicer;

import com.hrmanagement.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerExceptionHandler {
    private final Logger LOGGER = LogManager.getLogger(RestControllerExceptionHandler.class);

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e, HttpServletRequest request) {
        LOGGER.error("Advice handException {}, {}", request.getRequestURI(),e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("code", Integer.toString(e.getHttpStatusCode()));
        map.put("message", e.getMessage());
        return new ResponseEntity<>(map,httpHeaders,e.getHttpStatus());
    }
}
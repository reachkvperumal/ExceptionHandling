package com.kv.demo.jackson.demo.configuration;

import com.kv.demo.jackson.demo.exceptions.DemoException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DemoException.class})
    public ResponseEntity<Object> exception(RuntimeException ex, WebRequest request) {
        log.error(ExceptionUtils.getRootCauseMessage(ex));
        String bodyOfResponse = "Application failed to process this request";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<Object> unknown(RuntimeException ex, WebRequest request) {
        log.error(ExceptionUtils.getRootCauseMessage(ex));
        String bodyOfResponse = "Unknown exception.";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }
}

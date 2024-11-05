package com.noscendo.authorize.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionService extends ResponseEntityExceptionHandler {

    /*@Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (ex.getCause().getCause() instanceof AuthorizationDeniedException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(ex.getCause().getMessage());
        }
        return super.handleHttpMessageNotWritable(ex, headers, status, request);
    }*/
}

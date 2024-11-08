package com.noscendo.authorize.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlesJacksonException {

	@ExceptionHandler(HttpMessageNotWritableException.class)
	ResponseEntity<?> handleWrite(HttpMessageNotWritableException ex) {
		if (ex.getRootCause() instanceof AuthorizationDeniedException denied) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		throw ex;
	}
}

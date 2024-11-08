package com.noscendo.authorize.service;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

@ControllerAdvice
public class HandlesJacksonException {

	@ExceptionHandler(HttpMessageNotWritableException.class)
	View handleWrite(HttpMessageNotWritableException ex) {
		if (ex.getRootCause() instanceof AuthorizationDeniedException denied) {
			return new AbstractView() {
				@Override
				protected void renderMergedOutputModel(Map<String, Object> model,
						HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					throw ex;
				}
			};
		}
		throw ex;
	}
}

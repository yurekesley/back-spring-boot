package com.example.demospringboot.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demospringboot.error.ResourceNotFoundExecption;
import com.example.demospringboot.error.datails.ResourceNotFoundDetails;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundExecption.class)
	public ResponseEntity<?> handlerResourceNotFoundExecption(ResourceNotFoundExecption rnfe) {
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder.newBuilder()
		.timestamp(new Date().getTime())
		.status(HttpStatus.NOT_FOUND.value())
		.title("Resource not found")
		.detail(rnfe.getMessage())
		.developerMessage(rnfe.getClass().getName())
		.build();
		return new ResponseEntity<Object>(rnfDetails, HttpStatus.NOT_FOUND);
	}
}

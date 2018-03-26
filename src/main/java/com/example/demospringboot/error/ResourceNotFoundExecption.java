package com.example.demospringboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends RuntimeException {
	public ResourceNotFoundExecption(String msg) {
		super(msg);
	}
}

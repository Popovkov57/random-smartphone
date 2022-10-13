package com.api.randomsmartphone.builder;

import org.springframework.http.ResponseEntity;

import com.api.randomsmartphone.error.ApiError;

public class ResponseEntityBuilder {
	
	public static ResponseEntity<Object> build(ApiError apiError) {
	      return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}

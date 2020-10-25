package com.luv2code.springboot.recruit.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.springboot.recruit.entity.ErroResponse;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroResponse> handleGenericException(Exception e){
		ErroResponse er = new ErroResponse();
		er.setTitle(e.getMessage());
		System.out.println(e.getMessage());
		er.setStatus(HttpStatus.NOT_FOUND);
		er.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
}

package com.terrapay.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestController
@ControllerAdvice
public class CustomisedException extends ResponseEntityExceptionHandler {
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="User already exists for this email")
	@ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(Exception exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("User already exists for this email");
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response,HttpStatus.CONFLICT);
        return entity;
    }

}

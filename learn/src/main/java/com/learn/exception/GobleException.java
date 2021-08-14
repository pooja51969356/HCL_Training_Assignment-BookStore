package com.learn.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GobleException {
	
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> noRecordFound(NotFoundException e, HttpServletRequest request) {

        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Record Not Found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
	  public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {

        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Record Not Found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	  public ResponseEntity<StandardError> illegalNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {

      StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
              "Please Check The Http Request Method !!!!!!!", e.getMessage(), request.getRequestURI());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }
}

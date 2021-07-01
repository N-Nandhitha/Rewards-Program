package com.bskm.springboot.exception;

import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bskm.springboot.model.Message;

@ControllerAdvice
public class RewardsExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RewardsExceptionHandler.class);

	@ExceptionHandler({ InvalidAmountException.class })
	public ResponseEntity<Message> handleInvlidAmountException(Exception ex) {
		String errorId = UUID.randomUUID().toString();
		LocalDateTime timeStamp = LocalDateTime.now();
		Message msg = new Message(errorId, ex.getMessage(), "WARNING", timeStamp);
		return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ NoHandlerFoundException.class })
	public ResponseEntity<Message> handleNoHandlerFoundException(Exception ex) {
		String errorId = UUID.randomUUID().toString();
		LocalDateTime timeStamp = LocalDateTime.now();
		Message msg = new Message(errorId, ex.getMessage(), "WARNING", timeStamp);
		return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Message> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		String error = "The input parameter" + ex.getName() + " should be of type " + ex.getRequiredType().getName();
		String errorId = UUID.randomUUID().toString();
		LocalDateTime timeStamp = LocalDateTime.now();
		Message msg = new Message(errorId, error, "ERROR", timeStamp);
		logger.error("There is mismatch of parameter types", ex);
		return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
	}

}

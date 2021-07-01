package com.bskm.springboot.exception;

public class InvalidAmountException extends Exception{
	
	String message;

	public InvalidAmountException(String message) {
		super(message);
		this.message = message;
	}
	

}

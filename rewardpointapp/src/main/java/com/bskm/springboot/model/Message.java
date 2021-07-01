package com.bskm.springboot.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {
	String errorId;
	String message;
	String type;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime timeStamp;

	public Message(String errorId, String message, String type, LocalDateTime timeStamp) {
		super();
		this.errorId = errorId;
		this.message = message;
		this.type = type;
		this.timeStamp = timeStamp;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}

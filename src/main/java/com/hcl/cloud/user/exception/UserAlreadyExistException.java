package com.hcl.cloud.user.exception;


public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "USER DOES NOT EXIST";
	private int status = 404;
	
	public UserAlreadyExistException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}
}

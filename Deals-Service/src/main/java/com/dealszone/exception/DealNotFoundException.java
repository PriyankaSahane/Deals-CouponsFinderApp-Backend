package com.dealszone.exception;

public class DealNotFoundException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public  DealNotFoundException(String message) {
		
		super(message);
		this.message=message;
	}
	
	public DealNotFoundException() {
		
	}
}

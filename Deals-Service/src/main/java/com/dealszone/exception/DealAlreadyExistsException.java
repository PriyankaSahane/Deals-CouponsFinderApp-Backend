package com.dealszone.exception;

public class DealAlreadyExistsException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	  public DealAlreadyExistsException(String message) {
		  
		super(message);
		this.message=message;
	}
	
	public DealAlreadyExistsException() {
		
	}

}

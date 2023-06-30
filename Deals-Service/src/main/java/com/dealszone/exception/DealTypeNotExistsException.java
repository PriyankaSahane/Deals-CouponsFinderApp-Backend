package com.dealszone.exception;

public class DealTypeNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
  public DealTypeNotExistsException(String message) {
		
		super(message);
		this.message=message;
	}
		
		
		
	public DealTypeNotExistsException() {
		
	}
}

package com.couponszone.exception;

public class CouponTypeNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
  public CouponTypeNotExistsException(String message) {
		
		super(message);
		this.message=message;
	}
		
		
		
	public CouponTypeNotExistsException() {
		
	}
}

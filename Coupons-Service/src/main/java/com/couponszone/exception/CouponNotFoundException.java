package com.couponszone.exception;

public class CouponNotFoundException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public  CouponNotFoundException(String message) {
		
		super(message);
		this.message=message;
	}
	
	public CouponNotFoundException() {
		
	}
}

package com.dbCodingTest.tradeStorage.exception;

public class InvalidTradeException extends RuntimeException{

	private final String id; 
	
	public InvalidTradeException (final String id) {
		
		super ("Invalid trade: " + id);
		this.id=id;
		
	}
	
	public String getId() {
		return id; 
		
	}

}
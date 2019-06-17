package com.itopener.framework.support;

public enum RequestMethodEnum {

	GET(0b000000000001), 
	HEAD(0b000000000010), 
	POST(0b000000000100), 
	PUT(0b000000001000), 
	PATCH(0b000000010000), 
	DELETE(0b000000100000), 
	OPTIONS(0b000001000000), 
	TRACE(0b000010000000);
	
	private RequestMethodEnum(int code) {
		this.code = code;
	}

	private int code;

	public int getCode() {
		return code;
	}
}

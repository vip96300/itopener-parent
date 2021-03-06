package com.itopener.demo.es.enums;

public enum UserStateEnum implements StateEnum {

	NORMAL(CODE_NORMAL, "正常"),
	INVALID(CODE_INVALID, "禁用");
	
	private byte code;
	
	private String name;
	
	UserStateEnum(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	public byte getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}

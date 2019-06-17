package com.itopener.demo.dubbo.sdk.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserDTO implements Serializable {

	/** */
	private static final long serialVersionUID = 3803230032606909005L;

	private long id;
	
	private String name;
	
	private Timestamp createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}

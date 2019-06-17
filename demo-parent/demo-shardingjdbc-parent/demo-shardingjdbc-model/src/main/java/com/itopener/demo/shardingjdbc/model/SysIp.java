package com.itopener.demo.shardingjdbc.model;

import java.sql.Timestamp;

import com.itopener.framework.base.BaseCondition;

/**
 * @author fuwei.deng
 * @date 2017年12月18日 下午1:22:25
 * @version 1.0.0
 */
public class SysIp extends BaseCondition {

	/** */
	private static final long serialVersionUID = -1996345124584179178L;

	/** 主键*/
	private long id;
	
	/** IP地址*/
	private String ipAddress;
	
	/** 数据中心ID*/
	private long dataCenterId;
	
	/** 创建时间*/
	private Timestamp createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(long dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}

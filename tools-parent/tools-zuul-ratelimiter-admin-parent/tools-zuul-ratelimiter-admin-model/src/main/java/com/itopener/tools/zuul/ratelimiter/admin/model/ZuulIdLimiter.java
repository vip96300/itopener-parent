package com.itopener.tools.zuul.ratelimiter.admin.model;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * @desc 
 * @author fuwei.deng
 * @date 2018-02-05 15:04:23
 */
public class ZuulIdLimiter implements Serializable {

	/** SerialVersionUID*/
	private static final long serialVersionUID = -6446812879022748841L;

	/** 主键*/
	private long id;

	/** zuul服务id*/
	private String zuulId;

	/** 每秒限制数量*/
	private BigDecimal permitsPerSecond;

	/** 获取许可数量*/
	private int permits;

	/** 获取许可超时时间*/
	private long timeout;

	/** 获取许可超时时间单位*/
	private String timeUnit;

	/** 超过限流时的错误码*/
	private int statusCode;

	/** 超过限流时的错误原因*/
	private String errorCause;

	/** 是否启用*/
	private boolean enable;

	public long getId() {
		return id;
	}

	public ZuulIdLimiter setId(long id) {
		this.id = id;
		return this;
	}

	public String getZuulId() {
		return zuulId;
	}

	public ZuulIdLimiter setZuulId(String zuulId) {
		this.zuulId = zuulId;
		return this;
	}

	public BigDecimal getPermitsPerSecond() {
		return permitsPerSecond;
	}

	public ZuulIdLimiter setPermitsPerSecond(BigDecimal permitsPerSecond) {
		this.permitsPerSecond = permitsPerSecond;
		return this;
	}

	public int getPermits() {
		return permits;
	}

	public ZuulIdLimiter setPermits(int permits) {
		this.permits = permits;
		return this;
	}

	public long getTimeout() {
		return timeout;
	}

	public ZuulIdLimiter setTimeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public ZuulIdLimiter setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
		return this;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public ZuulIdLimiter setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getErrorCause() {
		return errorCause;
	}

	public ZuulIdLimiter setErrorCause(String errorCause) {
		this.errorCause = errorCause;
		return this;
	}

	public boolean getEnable() {
		return enable;
	}

	public ZuulIdLimiter setEnable(boolean enable) {
		this.enable = enable;
		return this;
	}
}
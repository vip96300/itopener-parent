package com.itopener.tools.zuul.ratelimiter.admin.model;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * @desc 
 * @author fuwei.deng
 * @date 2018-02-05 15:04:23
 */
public class ZuulPathLimiter implements Serializable {

	/** SerialVersionUID*/
	private static final long serialVersionUID = 3214529700462672612L;

	/** 主键*/
	private long id;

	/** 所属的zuul路由配置的id*/
	private String zuulId;

	/** 访问路径*/
	private String path;

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

	public ZuulPathLimiter setId(long id) {
		this.id = id;
		return this;
	}

	public String getZuulId() {
		return zuulId;
	}

	public ZuulPathLimiter setZuulId(String zuulId) {
		this.zuulId = zuulId;
		return this;
	}

	public String getPath() {
		return path;
	}

	public ZuulPathLimiter setPath(String path) {
		this.path = path;
		return this;
	}

	public BigDecimal getPermitsPerSecond() {
		return permitsPerSecond;
	}

	public ZuulPathLimiter setPermitsPerSecond(BigDecimal permitsPerSecond) {
		this.permitsPerSecond = permitsPerSecond;
		return this;
	}

	public int getPermits() {
		return permits;
	}

	public ZuulPathLimiter setPermits(int permits) {
		this.permits = permits;
		return this;
	}

	public long getTimeout() {
		return timeout;
	}

	public ZuulPathLimiter setTimeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public ZuulPathLimiter setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
		return this;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public ZuulPathLimiter setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getErrorCause() {
		return errorCause;
	}

	public ZuulPathLimiter setErrorCause(String errorCause) {
		this.errorCause = errorCause;
		return this;
	}

	public boolean getEnable() {
		return enable;
	}

	public ZuulPathLimiter setEnable(boolean enable) {
		this.enable = enable;
		return this;
	}
}
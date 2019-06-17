package com.itopener.tools.zuul.ratelimiter.admin.conditions;

import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulIdLimiter;

/**
 * @desc ZuulIdLimiter查询条件辅助类
 * @author fuwei.deng
 * @date 2018-02-05 15:04:23
 */
public class ZuulIdLimiterCondition extends ZuulIdLimiter {

	/** SerialVersionUID*/
	private static final long serialVersionUID = 2171452927606316947L;

	/** 分页查询--页数*/
	private int page;

	/** 分页查询--每页数量*/
	private int size;

	/** 排序*/
	private String orderBy;

	public ZuulIdLimiterCondition setPage(int page) {
		this.page = page;
		return this;
	}

	public int getPage() {
		return page;
	}

	public ZuulIdLimiterCondition setSize(int size) {
		this.size = size;
		return this;
	}

	public int getSize() {
		return size;
	}

	public ZuulIdLimiterCondition setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public String getOrderBy() {
		return orderBy;
	}
}
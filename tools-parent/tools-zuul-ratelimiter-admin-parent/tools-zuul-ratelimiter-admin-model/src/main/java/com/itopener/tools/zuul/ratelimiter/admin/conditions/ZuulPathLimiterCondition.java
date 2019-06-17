package com.itopener.tools.zuul.ratelimiter.admin.conditions;

import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulPathLimiter;

/**
 * @desc ZuulPathLimiter查询条件辅助类
 * @author fuwei.deng
 * @date 2018-02-05 15:04:23
 */
public class ZuulPathLimiterCondition extends ZuulPathLimiter {

	/** SerialVersionUID*/
	private static final long serialVersionUID = -3062543415321260875L;

	/** 分页查询--页数*/
	private int page;

	/** 分页查询--每页数量*/
	private int size;

	/** 排序*/
	private String orderBy;

	public ZuulPathLimiterCondition setPage(int page) {
		this.page = page;
		return this;
	}

	public int getPage() {
		return page;
	}

	public ZuulPathLimiterCondition setSize(int size) {
		this.size = size;
		return this;
	}

	public int getSize() {
		return size;
	}

	public ZuulPathLimiterCondition setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public String getOrderBy() {
		return orderBy;
	}
}
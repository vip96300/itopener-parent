package com.itopener.framework.base;

import java.io.Serializable;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
public class BaseCondition implements Serializable {

	/** */
	private static final long serialVersionUID = -3060587334346476150L;

	/** 分页查询--页数*/
	private int page;

	/** 分页查询--每页数量*/
	private int size;

	/** 排序*/
	private String orderBy;

	public int getPage() {
		return page;
	}

	public BaseCondition setPage(int page) {
		this.page = page;
		return this;
	}

	public int getSize() {
		return size;
	}

	public BaseCondition setSize(int size) {
		this.size = size;
		return this;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public BaseCondition setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
}

package com.itopener.demo.shardingjdbc.model;

import java.sql.Timestamp;

import com.itopener.framework.base.BaseCondition;

/**
 * @desc 
 * @author fuwei.deng
 * @date 2017-12-15 18:47:07
 */
public class OrderItem extends BaseCondition {

	/** SerialVersionUID*/
	private static final long serialVersionUID = 2593773339452632355L;

	/** ID*/
	private long id;

	/** 订单ID*/
	private long orderId;

	/** 用户ID*/
	private long userId;

	/** 状态*/
	private int state;
	
	/** 修改时间*/
	private Timestamp updateTime;

	public long getId() {
		return id;
	}

	public OrderItem setId(long id) {
		this.id = id;
		return this;
	}

	public long getOrderId() {
		return orderId;
	}

	public OrderItem setOrderId(long orderId) {
		this.orderId = orderId;
		return this;
	}

	public long getUserId() {
		return userId;
	}

	public OrderItem setUserId(long userId) {
		this.userId = userId;
		return this;
	}

	public int getState() {
		return state;
	}

	public OrderItem setState(int state) {
		this.state = state;
		return this;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public OrderItem setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
		return this;
	}
}
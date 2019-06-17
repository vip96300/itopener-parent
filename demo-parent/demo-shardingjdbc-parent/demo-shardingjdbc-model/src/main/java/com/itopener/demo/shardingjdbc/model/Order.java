package com.itopener.demo.shardingjdbc.model;

import java.sql.Timestamp;
import java.util.List;

import com.itopener.framework.base.BaseCondition;

/**
 * @desc 
 * @author fuwei.deng
 * @date 2017-12-15 18:47:07
 */
public class Order extends BaseCondition {

	/** SerialVersionUID*/
	private static final long serialVersionUID = -1135753261807170475L;

	/** ID*/
	private long id;

	/** 用户ID*/
	private long userId;

	/** 状态*/
	private int state;
	
	/** 修改时间*/
	private Timestamp updateTime;
	
	private List<OrderItem> orderItemList;

	public long getId() {
		return id;
	}

	public Order setId(long id) {
		this.id = id;
		return this;
	}

	public long getUserId() {
		return userId;
	}

	public Order setUserId(long userId) {
		this.userId = userId;
		return this;
	}

	public int getState() {
		return state;
	}

	public Order setState(int state) {
		this.state = state;
		return this;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public Order setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public Order setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
		return this;
	}
	
}
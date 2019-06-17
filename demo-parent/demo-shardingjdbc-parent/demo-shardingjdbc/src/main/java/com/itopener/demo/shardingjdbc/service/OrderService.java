package com.itopener.demo.shardingjdbc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itopener.demo.shardingjdbc.conditions.OrderCondition;
import com.itopener.demo.shardingjdbc.dao.OrderDao;
import com.itopener.demo.shardingjdbc.dao.OrderItemDao;
import com.itopener.demo.shardingjdbc.model.Order;
import com.itopener.demo.shardingjdbc.model.OrderItem;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
@Service
public class OrderService {
	
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private OrderItemDao orderItemDao;
	
	@Transactional
	public void add(Order order){
		orderDao.insert(order);
		for(OrderItem orderItem : order.getOrderItemList()) {
			orderItemDao.insert(orderItem);
		}
		throw new RuntimeException("test transaction");
	}
	
	@Transactional
	public void update(Order order){
		orderDao.update(order);
		for(OrderItem orderItem : order.getOrderItemList()) {
			orderItemDao.update(orderItem);
		}
	}
	
	public List<Order> select(OrderCondition condition){
		return orderDao.selectList(condition);
	}
	
	public Order selectById(long id){
		return orderDao.selectById(id);
	}
	
	@Transactional
	public void delete(Order order, OrderItem orderItem){
		orderDao.delete(order);
		orderItemDao.deleteByOrderId(orderItem);
	}
	
}

package com.itopener.demo.shardingjdbc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itopener.demo.shardingjdbc.conditions.OrderItemCondition;
import com.itopener.demo.shardingjdbc.dao.OrderItemDao;
import com.itopener.demo.shardingjdbc.model.OrderItem;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
@Service
public class OrderItemService {
	
	@Resource
	private OrderItemDao orderItemDao;
	
	@Transactional
	public List<OrderItem> select(OrderItemCondition condition){
		return orderItemDao.selectList(condition);
	}
}

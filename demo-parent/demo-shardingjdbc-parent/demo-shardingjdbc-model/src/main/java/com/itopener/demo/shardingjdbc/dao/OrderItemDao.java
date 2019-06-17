package com.itopener.demo.shardingjdbc.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.PageHelper;

import com.itopener.framework.base.BaseDao;
import com.itopener.demo.shardingjdbc.model.OrderItem;
import com.itopener.demo.shardingjdbc.conditions.OrderItemCondition;

@Repository
public class OrderItemDao {

	private final String NAMESPACE = "com.itopener.demo.shardingjdbc.mapper.OrderItemMapper.";

	@Resource
	private BaseDao baseDao;

	public int insert(OrderItem orderItem) {
		return baseDao.insert(NAMESPACE + "insert", orderItem);
	}

	public List<OrderItem> selectList(OrderItemCondition condition) {
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public List<OrderItem> selectPage(OrderItemCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getSize(), false);
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public long selectCount(OrderItemCondition condition) {
		return baseDao.selectOne(NAMESPACE + "selectCount", condition);
	}

	public OrderItem selectOne(OrderItemCondition condition) {
		return baseDao.selectOne(NAMESPACE + "select", condition);
	}

	public OrderItem selectById(long id) {
		return baseDao.selectOne(NAMESPACE + "selectById", id);
	}

	public int update(OrderItem orderItem) {
		return baseDao.update(NAMESPACE + "update", orderItem);
	}

	public int delete(OrderItem orderItem) {
		return baseDao.delete(NAMESPACE + "delete", orderItem);
	}
	
	public int deleteByOrderId(OrderItem orderItem) {
		return baseDao.delete(NAMESPACE + "deleteByOrderId", orderItem);
	}

}
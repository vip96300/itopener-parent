package com.itopener.demo.shardingjdbc.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.PageHelper;

import com.itopener.framework.base.BaseDao;
import com.itopener.demo.shardingjdbc.model.Order;
import com.itopener.demo.shardingjdbc.conditions.OrderCondition;

@Repository
public class OrderDao {

	private final String NAMESPACE = "com.itopener.demo.shardingjdbc.mapper.OrderMapper.";

	@Resource
	private BaseDao baseDao;

	public int insert(Order order) {
		return baseDao.insert(NAMESPACE + "insert", order);
	}

	public List<Order> selectList(OrderCondition condition) {
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public List<Order> selectPage(OrderCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getSize(), false);
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public long selectCount(OrderCondition condition) {
		return baseDao.selectOne(NAMESPACE + "selectCount", condition);
	}

	public Order selectOne(OrderCondition condition) {
		return baseDao.selectOne(NAMESPACE + "select", condition);
	}

	public Order selectById(long id) {
		return baseDao.selectOne(NAMESPACE + "selectById", id);
	}

	public int update(Order order) {
		return baseDao.update(NAMESPACE + "update", order);
	}

	public int delete(Order order) {
		return baseDao.update(NAMESPACE + "delete", order);
	}

}
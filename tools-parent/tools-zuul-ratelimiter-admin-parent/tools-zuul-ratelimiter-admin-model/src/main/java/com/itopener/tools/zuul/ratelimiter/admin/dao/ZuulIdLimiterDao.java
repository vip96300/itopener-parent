package com.itopener.tools.zuul.ratelimiter.admin.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.PageHelper;

import com.itopener.framework.base.BaseDao;
import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulIdLimiter;
import com.itopener.tools.zuul.ratelimiter.admin.conditions.ZuulIdLimiterCondition;

@Repository
public class ZuulIdLimiterDao {

	private final String NAMESPACE = "com.itopener.tools.zuul.ratelimiter.admin.mapper.ZuulIdLimiterMapper.";

	@Resource
	private BaseDao baseDao;

	public int insert(ZuulIdLimiter zuulIdLimiter) {
		return baseDao.insert(NAMESPACE + "insert", zuulIdLimiter);
	}

	public List<ZuulIdLimiter> selectList(ZuulIdLimiterCondition condition) {
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public List<ZuulIdLimiter> selectPage(ZuulIdLimiterCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getSize(), false);
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public long selectCount(ZuulIdLimiterCondition condition) {
		return baseDao.selectOne(NAMESPACE + "selectCount", condition);
	}

	public ZuulIdLimiter selectOne(ZuulIdLimiterCondition condition) {
		return baseDao.selectOne(NAMESPACE + "select", condition);
	}

	public ZuulIdLimiter selectById(long id) {
		return baseDao.selectOne(NAMESPACE + "selectById", id);
	}

	public int update(ZuulIdLimiter zuulIdLimiter) {
		return baseDao.update(NAMESPACE + "update", zuulIdLimiter);
	}
	
	public int updateEnable(ZuulIdLimiter zuulIdLimiter) {
		return baseDao.update(NAMESPACE + "updateEnable", zuulIdLimiter);
	}

	public int delete(ZuulIdLimiter zuulIdLimiter) {
		return baseDao.update(NAMESPACE + "delete", zuulIdLimiter);
	}

}
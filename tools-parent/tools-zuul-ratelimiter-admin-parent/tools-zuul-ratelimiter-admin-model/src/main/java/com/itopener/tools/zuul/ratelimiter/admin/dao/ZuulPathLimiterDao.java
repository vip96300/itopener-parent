package com.itopener.tools.zuul.ratelimiter.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.itopener.framework.base.BaseDao;
import com.itopener.tools.zuul.ratelimiter.admin.conditions.ZuulPathLimiterCondition;
import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulPathLimiter;

@Repository
public class ZuulPathLimiterDao {

	private final String NAMESPACE = "com.itopener.tools.zuul.ratelimiter.admin.mapper.ZuulPathLimiterMapper.";

	@Resource
	private BaseDao baseDao;

	public int insert(ZuulPathLimiter zuulPathLimiter) {
		return baseDao.insert(NAMESPACE + "insert", zuulPathLimiter);
	}

	public List<ZuulPathLimiter> selectList(ZuulPathLimiterCondition condition) {
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public List<ZuulPathLimiter> selectPage(ZuulPathLimiterCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getSize(), false);
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public long selectCount(ZuulPathLimiterCondition condition) {
		return baseDao.selectOne(NAMESPACE + "selectCount", condition);
	}

	public ZuulPathLimiter selectOne(ZuulPathLimiterCondition condition) {
		return baseDao.selectOne(NAMESPACE + "select", condition);
	}

	public ZuulPathLimiter selectById(long id) {
		return baseDao.selectOne(NAMESPACE + "selectById", id);
	}

	public int update(ZuulPathLimiter zuulPathLimiter) {
		return baseDao.update(NAMESPACE + "update", zuulPathLimiter);
	}
	
	public int updateEnable(ZuulPathLimiter zuulPathLimiter) {
		return baseDao.update(NAMESPACE + "updateEnable", zuulPathLimiter);
	}

	public int delete(ZuulPathLimiter zuulPathLimiter) {
		return baseDao.update(NAMESPACE + "delete", zuulPathLimiter);
	}

}
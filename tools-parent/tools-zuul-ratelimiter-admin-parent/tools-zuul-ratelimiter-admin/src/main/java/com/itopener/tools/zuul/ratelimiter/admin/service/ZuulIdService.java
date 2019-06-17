package com.itopener.tools.zuul.ratelimiter.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itopener.tools.zuul.ratelimiter.admin.conditions.ZuulIdLimiterCondition;
import com.itopener.tools.zuul.ratelimiter.admin.dao.ZuulIdLimiterDao;
import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulIdLimiter;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 下午3:17:35
 * @version 1.0.0
 */
@Service
public class ZuulIdService {

	@Resource
	private ZuulIdLimiterDao zuulIdLimiterDao;
	
	public List<ZuulIdLimiter> limiters(ZuulIdLimiterCondition condition){
		return zuulIdLimiterDao.selectList(condition);
	}
	
	public long count(ZuulIdLimiterCondition condition) {
		return zuulIdLimiterDao.selectCount(condition);
	}
	
	public void add(ZuulIdLimiter zuulIdLimiter) {
		zuulIdLimiterDao.insert(zuulIdLimiter);
	}
	
	public void update(ZuulIdLimiter zuulIdLimiter) {
		zuulIdLimiterDao.update(zuulIdLimiter);
	}
	
	public void updateEnable(ZuulIdLimiter zuulIdLimiter) {
		zuulIdLimiterDao.updateEnable(zuulIdLimiter);
	}
	
	public void delete(ZuulIdLimiter zuulIdLimiter) {
		zuulIdLimiterDao.delete(zuulIdLimiter);
	}
}

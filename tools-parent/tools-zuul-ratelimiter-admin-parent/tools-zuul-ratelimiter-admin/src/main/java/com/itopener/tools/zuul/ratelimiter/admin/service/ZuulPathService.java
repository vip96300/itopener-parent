package com.itopener.tools.zuul.ratelimiter.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itopener.tools.zuul.ratelimiter.admin.conditions.ZuulPathLimiterCondition;
import com.itopener.tools.zuul.ratelimiter.admin.dao.ZuulPathLimiterDao;
import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulPathLimiter;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 下午3:17:35
 * @version 1.0.0
 */
@Service
public class ZuulPathService {

	@Resource
	private ZuulPathLimiterDao zuulPathLimiterDao;
	
	public List<ZuulPathLimiter> limiters(ZuulPathLimiterCondition condition){
		return zuulPathLimiterDao.selectPage(condition);
	}
	
	public long count(ZuulPathLimiterCondition condition) {
		return zuulPathLimiterDao.selectCount(condition);
	}
	
	public void add(ZuulPathLimiter zuulPathLimiter) {
		zuulPathLimiterDao.insert(zuulPathLimiter);
	}
	
	public void update(ZuulPathLimiter zuulPathLimiter) {
		zuulPathLimiterDao.update(zuulPathLimiter);
	}
	
	public void updateEnable(ZuulPathLimiter zuulPathLimiter) {
		zuulPathLimiterDao.updateEnable(zuulPathLimiter);
	}
	
	public void delete(ZuulPathLimiter zuulPathLimiter) {
		zuulPathLimiterDao.delete(zuulPathLimiter);
	}
}

package com.itopener.tools.zuul.ratelimiter.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;
import com.itopener.tools.zuul.ratelimiter.admin.conditions.ZuulPathLimiterCondition;
import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulPathLimiter;
import com.itopener.tools.zuul.ratelimiter.admin.service.ZuulPathService;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 上午11:14:32
 * @version 1.0.0
 */
@RestController
@RequestMapping("zuul/path")
public class ZuulPathLimiterController {
	
	@Resource
	private ZuulPathService zuulPathService;

	/**
	 * @description 获取zuul path限流配置
	 * @author fuwei.deng
	 * @date 2018年2月5日 上午11:18:56
	 * @version 1.0.0
	 * @return
	 */
	@GetMapping
	public ResultMap limiters(ZuulPathLimiterCondition condition) {
		List<ZuulPathLimiter> limiters = zuulPathService.limiters(condition);
		return ResultMap.buildSuccess().put("limiters", limiters);
	}
	
	/**
	 * @description 保存zuul path限流配置（新增和修改）
	 * @author fuwei.deng
	 * @date 2018年2月5日 上午11:19:08
	 * @version 1.0.0
	 * @param zuulPathLimiter
	 * @return
	 */
	@PostMapping
	public ResultMap save(ZuulPathLimiter zuulPathLimiter) {
		if(zuulPathLimiter.getId() < 1) {
			zuulPathService.add(zuulPathLimiter);
		} else {
			zuulPathService.update(zuulPathLimiter);
		}
		return ResultMap.buildSuccess();
	}
	
	/**
	 * @description 删除zuul path路由配置
	 * @author fuwei.deng
	 * @date 2018年2月5日 上午11:20:35
	 * @version 1.0.0
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public ResultMap delete(@PathVariable long id) {
		ZuulPathLimiter zuulPathLimiter = new ZuulPathLimiter();
		zuulPathLimiter.setId(id);
		zuulPathService.delete(zuulPathLimiter);
		return ResultMap.buildSuccess();
	}
	
	@PutMapping("{id}")
	public ResultMap enable(@PathVariable long id, boolean enable) {
		ZuulPathLimiter zuulPathLimiter = new ZuulPathLimiter();
		zuulPathLimiter.setId(id);
		zuulPathLimiter.setEnable(enable);
		zuulPathService.updateEnable(zuulPathLimiter);
		return ResultMap.buildSuccess();
	}
}

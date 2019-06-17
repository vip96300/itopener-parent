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
import com.itopener.framework.base.Assert;
import com.itopener.framework.base.BaseRuntimeException;
import com.itopener.tools.zuul.ratelimiter.admin.conditions.ZuulIdLimiterCondition;
import com.itopener.tools.zuul.ratelimiter.admin.model.ZuulIdLimiter;
import com.itopener.tools.zuul.ratelimiter.admin.service.ZuulIdService;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 上午11:14:32
 * @version 1.0.0
 */
@RestController
@RequestMapping("zuul/id")
public class ZuulIdLimiterController {
	
	@Resource
	private ZuulIdService zuulIdService;

	/**
	 * @description 获取zuul id限流配置
	 * @author fuwei.deng
	 * @date 2018年2月5日 上午11:18:56
	 * @version 1.0.0
	 * @return
	 */
	@GetMapping
	public ResultMap limiters(ZuulIdLimiterCondition condition) {
		List<ZuulIdLimiter> limiters = zuulIdService.limiters(condition);
		return ResultMap.buildSuccess().put("limiters", limiters);
	}
	
	/**
	 * @description 保存zuul id限流配置（新增和修改）
	 * @author fuwei.deng
	 * @date 2018年2月5日 上午11:19:08
	 * @version 1.0.0
	 * @param zuulIdLimiter
	 * @return
	 */
	@PostMapping
	public ResultMap save(ZuulIdLimiter zuulIdLimiter) {
		try {
			validate(zuulIdLimiter);
			if(zuulIdLimiter.getId() < 1) {
				zuulIdService.add(zuulIdLimiter);
			} else {
				zuulIdService.update(zuulIdLimiter);
			}
			return ResultMap.buildSuccess();
		} catch (BaseRuntimeException e) {
			return ResultMap.buildFailed(e.getMessage());
		}
	}
	
	private void validate(ZuulIdLimiter zuulIdLimiter) {
		Assert.notEmpty("Zuul服务配置id不能为空", zuulIdLimiter.getZuulId());
		Assert.notNull("每秒限制数量不能为空", zuulIdLimiter.getPermitsPerSecond());
		Assert.positiveInteger("超过限流时的错误码必须为正整数", zuulIdLimiter.getStatusCode());
		Assert.notEmpty("超过限流时的错误原因不能为空", zuulIdLimiter.getErrorCause());
	}
	
	/**
	 * @description 删除zuul id路由配置
	 * @author fuwei.deng
	 * @date 2018年2月5日 上午11:20:35
	 * @version 1.0.0
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public ResultMap delete(@PathVariable long id) {
		ZuulIdLimiter zuulIdLimiter = new ZuulIdLimiter();
		zuulIdLimiter.setId(id);
		zuulIdService.delete(zuulIdLimiter);
		return ResultMap.buildSuccess();
	}
	
	@PutMapping("{id}")
	public ResultMap enable(@PathVariable long id, boolean enable) {
		ZuulIdLimiter zuulIdLimiter = new ZuulIdLimiter();
		zuulIdLimiter.setId(id);
		zuulIdLimiter.setEnable(enable);
		zuulIdService.updateEnable(zuulIdLimiter);
		return ResultMap.buildSuccess();
	}
	
}

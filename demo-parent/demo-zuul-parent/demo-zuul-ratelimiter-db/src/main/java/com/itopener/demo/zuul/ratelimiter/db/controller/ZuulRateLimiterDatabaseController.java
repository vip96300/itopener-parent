package com.itopener.demo.zuul.ratelimiter.db.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;
import com.itopener.zuul.ratelimiter.spring.boot.common.support.RateLimiterHandler;

/**
 * @author fuwei.deng
 * @date 2017年6月30日 下午1:25:23
 * @version 1.0.0
 */
@RestController
@RequestMapping("db")
public class ZuulRateLimiterDatabaseController {

	@Resource
	private RateLimiterHandler rateLimiterHandler;

	@RequestMapping("/refresh")
	public ResultMap refreshRoute() {
		rateLimiterHandler.generateRateLimiterMap();
		return ResultMap.buildSuccess();
	}

}
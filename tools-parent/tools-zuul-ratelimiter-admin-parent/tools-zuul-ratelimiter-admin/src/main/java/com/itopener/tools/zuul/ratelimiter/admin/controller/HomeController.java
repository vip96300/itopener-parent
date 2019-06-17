package com.itopener.tools.zuul.ratelimiter.admin.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;
import com.itopener.tools.zuul.ratelimiter.admin.service.ZuulIdService;
import com.itopener.tools.zuul.ratelimiter.admin.service.ZuulPathService;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 下午5:50:02
 * @version 1.0.0
 */
@RestController
public class HomeController {

	@Resource
	private ZuulIdService zuulIdService;
	
	@Resource
	private ZuulPathService zuulPathService;
	
	@GetMapping("home")
	public ResultMap home() {
		return ResultMap.buildSuccess().put("zuulIdCount", zuulIdService.count(null)).put("zuulPathCount", zuulPathService.count(null));
	}
}

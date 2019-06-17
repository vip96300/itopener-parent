package com.itopener.demo.cache.redis.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.demo.cache.redis.service.RedisCacheService;
import com.itopener.demo.cache.redis.vo.UserVO;
import com.itopener.framework.ResultMap;

@RestController
@RequestMapping("user")
public class RedisCacheController {

	@Resource
	private RedisCacheService redisCacheService;
	
	@GetMapping("id/{id}")
	public ResultMap get(@PathVariable long id) {
		UserVO user = redisCacheService.get(id);
		return ResultMap.buildSuccess().put("user", user);
	}
	
	@GetMapping("name/{name}")
	public ResultMap get(@PathVariable String name) {
		UserVO user = redisCacheService.get(name);
		return ResultMap.buildSuccess().put("user", user);
	}
}

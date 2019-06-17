package com.itopener.demo.redisson.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;

/**
 * @author fuwei.deng
 * @date 2018年1月4日 下午2:28:52
 * @version 1.0.0
 */
@RestController
@RequestMapping("redisson/map")
public class RedissonMapController {
	
	@Resource
	private RedissonClient redissonClient;

	@GetMapping("{key}/{hashKey}")
	public ResultMap get(@PathVariable String key, @PathVariable String hashKey) {
		String value = (String) redissonClient.getMap(key).get(hashKey);
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount).put("value", value);
	}
	
	@GetMapping("{key}/{hashKey}/{value}")
	public ResultMap put(@PathVariable String key, @PathVariable String hashKey, @PathVariable String value) {
		redissonClient.getMap(key).put(hashKey, value);
		redissonClient.getMap(key).expire(5, TimeUnit.MINUTES);
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount);
	}
	
}

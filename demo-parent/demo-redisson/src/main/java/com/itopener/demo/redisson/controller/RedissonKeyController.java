package com.itopener.demo.redisson.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;

/**
 * @author fuwei.deng
 * @date 2018年1月4日 下午2:28:37
 * @version 1.0.0
 */
@RestController
@RequestMapping("redisson/key")
public class RedissonKeyController {

	@Resource
	private RedissonClient redissonClient;
	
	@GetMapping("type/{key}")
	public ResultMap type(@PathVariable String key) {
		RKeys keys = redissonClient.getKeys();
		String type = null;
		if(keys != null) {
			type = keys.getType(key).name();
		}
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount).put("type", type);
	}
	
	@GetMapping("time/{key}")
	public ResultMap time(@PathVariable String key) {
		long time = redissonClient.getKeys().remainTimeToLive(key);
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount).put("time", time);
	}
	
	@GetMapping("expire/{key}")
	public ResultMap expire(@PathVariable String key) {
		boolean result = redissonClient.getKeys().expire(key, 0, TimeUnit.MILLISECONDS);
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount).put("result", result);
	}
	
}

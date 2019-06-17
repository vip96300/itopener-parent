package com.itopener.demo.redisson.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;

/**
 * @author fuwei.deng
 * @date 2018年1月4日 下午2:28:41
 * @version 1.0.0
 */
@RestController
@RequestMapping("redisson/bucket")
public class RedissonBucketController {
	
	@Resource
	private RedissonClient redissonClient;

	@GetMapping("{key}")
	public ResultMap get(@PathVariable String key) {
		RBucket<String> bucket = redissonClient.getBucket(key);
		String value = bucket.get();
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount).put("value", value);
	}
	
	@PostMapping("{key}/{value}")
	public ResultMap put(@PathVariable String key, @PathVariable String value) {
		redissonClient.getBucket(key).set(value, 5, TimeUnit.MINUTES);
		long keyCount = redissonClient.getKeys().count();
		return ResultMap.buildSuccess().put("keyCount", keyCount);
	}
	
}

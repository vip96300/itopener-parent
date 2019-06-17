package com.itopener.demo.redislock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itopener.demo.redislock.vo.UserVO;
import com.itopener.lock.redis.spring.boot.autoconfigure.annotations.LockAction;

@Service
public class RedisLockService {

	private final Logger logger = LoggerFactory.getLogger(RedisLockService.class);
	
	@LockAction
	public void update(String key){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
	}
	
	@LockAction("#user.id")
	public void update(UserVO user){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
	}
	
}

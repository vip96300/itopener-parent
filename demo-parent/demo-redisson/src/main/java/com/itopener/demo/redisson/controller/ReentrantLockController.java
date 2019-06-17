package com.itopener.demo.redisson.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;

/**
 * 可重入锁ReentrantLock
 * @author fuwei.deng
 * @date 2018年1月4日 下午5:58:39
 * @version 1.0.0
 */
@RestController
@RequestMapping("redisson/reentrantLock")
public class ReentrantLockController {
	
	private final Logger logger = LoggerFactory.getLogger(ReentrantLockController.class);
	
	@Resource
	private RedissonClient redissonClient;

	@RequestMapping("lock")
	public ResultMap lock(){
		for(int i=0; i<10; i++){
			new LockThread().start();
		}
		return ResultMap.buildSuccess();
	}
	
	class LockThread extends Thread {

		@Override
		public void run() {
			String key = "lockKey";
			RLock lock = redissonClient.getLock(key);
//			lock.lock(1, TimeUnit.MINUTES);
			try {
				boolean result = lock.tryLock(1, 5, TimeUnit.MINUTES);
				logger.info(result ? "get lock success : " + key : "get lock failed : " + key);
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				logger.error("exp", e);
			} finally {
				lock.unlock();
				logger.info("release lock : " + key);
			}
		}
	}
}

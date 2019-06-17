package com.itopener.demo.redisson.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;

/**
 * 读写锁ReadWriteLock
 * @author fuwei.deng
 * @date 2018年1月4日 下午5:58:39
 * @version 1.0.0
 */
@RestController
@RequestMapping("redisson/readwritelock")
public class ReadWriteLockController {
	
	private final Logger logger = LoggerFactory.getLogger(ReadWriteLockController.class);
	
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
			RReadWriteLock lock = redissonClient.getReadWriteLock(key);
			try {
				// 获取锁，等到100秒，50秒后锁自动释放。两个时间参数的单位都是用的第三个参数
				boolean result = lock.readLock().tryLock(100, 50, TimeUnit.SECONDS);
//				boolean result = lock.writeLock().tryLock(100, 50, TimeUnit.SECONDS);
				logger.info(result ? "get lock success : " + key : "get lock failed : " + key);
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				logger.error("exp", e);
			} finally {
				lock.readLock().unlock();
//				lock.writeLock().unlock();
				logger.info("release lock : " + key);
			}
		}
	}
}

package com.itopener.demo.redisson.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.itopener.demo.redisson.vo.UserVO;

/**  
 * @author fuwei.deng
 * @date 2018年1月10日 下午3:28:21
 * @version 1.0.0
 */
@Service
public class RedissonCacheableService {
	
	private final Logger logger = LoggerFactory.getLogger(RedissonCacheableService.class);

	@Cacheable(key = "'cache_user_id_' + #userVO.id", value = "userIdCache", cacheManager = "cacheManager", sync = true)
	public UserVO get(UserVO userVO) {
		logger.info("get from src");
		return userVO;
	}
}

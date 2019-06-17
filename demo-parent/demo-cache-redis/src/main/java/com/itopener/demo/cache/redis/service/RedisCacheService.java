package com.itopener.demo.cache.redis.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.itopener.demo.cache.redis.vo.UserVO;
import com.itopener.utils.TimestampUtil;

@Service
public class RedisCacheService {
	
	private final Logger logger = LoggerFactory.getLogger(RedisCacheService.class);

	@Cacheable(key = "'cache_user_id_' + #id", value = "userIdCache", cacheManager = "cacheManager")
	public UserVO get(long id) {
		logger.info("get by id from db");
		return null;
//		UserVO user = new UserVO();
//		user.setId(id);
//		user.setName("name" + id);
//		user.setCreateTime(TimestampUtil.current());
//		return user;
	}
	
	@Cacheable(key = "'cache_user_name_' + #name", value = "userNameCache", cacheManager = "cacheManager")
	public UserVO get(String name) {
		logger.info("get by name from db");
		UserVO user = new UserVO();
		user.setId(new Random().nextLong());
		user.setName(name);
		user.setCreateTime(TimestampUtil.current());
		return user;
	}
}

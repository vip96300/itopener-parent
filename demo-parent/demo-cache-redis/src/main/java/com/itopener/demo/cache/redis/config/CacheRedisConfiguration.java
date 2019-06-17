package com.itopener.demo.cache.redis.config;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author fuwei.deng
 * @date 2017年12月22日 上午10:24:54
 * @version 1.0.0
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class CacheRedisConfiguration {
	
	@Bean
	public RedisCacheManagerCustomizer redisCacheManagerCustomizer() {
		return new RedisCacheManagerCustomizer();
	}
	
	@Bean
	public RedisCacheManager cacheManager(CacheProperties cacheProperties, RedisTemplate<Object, Object> redisTemplate) {
		return new RedisCacheManager(redisTemplate, cacheProperties.getCacheNames(), true);
	}
}

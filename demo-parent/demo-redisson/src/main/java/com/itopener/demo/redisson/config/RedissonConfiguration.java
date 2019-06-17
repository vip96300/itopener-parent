package com.itopener.demo.redisson.config;

import java.util.concurrent.TimeUnit;

import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.LocalCachedMapOptions.EvictionPolicy;
import org.redisson.api.LocalCachedMapOptions.ReconnectionStrategy;
import org.redisson.api.LocalCachedMapOptions.SyncStrategy;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuwei.deng
 * @date 2017年12月22日 上午10:24:54
 * @version 1.0.0
 */
@Configuration
public class RedissonConfiguration {
	
//	@Bean
//	public Config config() throws IOException {
//		File file = ResourceUtils.getFile("classpath:redisson.json");
//		return Config.fromJSON(file);
//	}
	
	@Bean
	public LocalCachedMapOptions<?, ?> localCachedMapOptions(){
		LocalCachedMapOptions<?, ?> options = LocalCachedMapOptions.defaults()
				// 淘汰机制有LFU, LRU和NONE这几种算法策略可供选择
				.evictionPolicy(EvictionPolicy.LFU).cacheSize(1)
				// 如果该值是`真(true)`时，在该实例执行更新和删除操作的同时，将向其他所有的相同实例发
				// 送针对该元素的淘汰消息。其他相同实例在收到该消息以后，会同时删除自身的缓存。下次读取
				// 该元素时会从Redis服务器获取。
				.syncStrategy(SyncStrategy.INVALIDATE)
				.reconnectionStrategy(ReconnectionStrategy.CLEAR)
				// 每个Map本地缓存里元素的有效时间，默认毫秒为单位
				.timeToLive(10000)
				// 或者
				.timeToLive(10, TimeUnit.SECONDS)
				// 每个Map本地缓存里元素的最长闲置时间，默认毫秒为单位
				.maxIdle(10000)
				// 或者
				.maxIdle(10, TimeUnit.SECONDS);
		return options;
	}
	
	@Bean
	public RLocalCachedMap<?, ?> localCachedMap(RedissonClient redissonClient, LocalCachedMapOptions<?, ?> localCachedMapOptions) {
		return redissonClient.getLocalCachedMap("123", localCachedMapOptions);
	}
}

package com.itopener.demo.hystrix.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itopener.framework.ResultMap;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrtixService {
	
	private final Logger logger = LoggerFactory.getLogger(HystrtixService.class);

	/**
	 * @description HystrixCommand注解默认超时时间是1s
	 * 		HystrixCommand注解配置属性参见 {@code HystrixCommandProperties}
	 * @author fuwei.deng
	 * @date 2018年2月8日 下午5:02:22
	 * @version 1.0.0
	 * @param id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "callFallback")
	public ResultMap call(long id){
		try {
			Thread.sleep(5000);
		} catch (Exception e){
			logger.error("sleep exception ", e);
		}
		return ResultMap.buildSuccess();
	}
	
	public ResultMap callFallback(long id){
		return ResultMap.buildFailed("hystrix fallback : " + id);
    }
}

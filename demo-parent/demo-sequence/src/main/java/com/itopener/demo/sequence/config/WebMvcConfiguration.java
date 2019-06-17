package com.itopener.demo.sequence.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.itopener.framework.interceptors.PerformanceInterceptor;

/**
 * @author fuwei.deng
 * @date 2018年1月25日 下午4:27:58
 * @version 1.0.0
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("add interceptors");
		registry.addInterceptor(new PerformanceInterceptor());
	}
}

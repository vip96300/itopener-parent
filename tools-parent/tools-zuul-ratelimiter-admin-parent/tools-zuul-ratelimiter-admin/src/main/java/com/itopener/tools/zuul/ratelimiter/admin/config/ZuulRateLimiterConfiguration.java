package com.itopener.tools.zuul.ratelimiter.admin.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.itopener.framework.base.BaseDao;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 下午1:49:32
 * @version 1.0.0
 */
@Configuration
public class ZuulRateLimiterConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public BaseDao baseDao() {
		return new BaseDao();
	}
}

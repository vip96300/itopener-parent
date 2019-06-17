package com.itopener.demo.ratelimiter.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itopener.framework.ResultMap;
import com.itopener.framework.base.BaseRuntimeException;
import com.itopener.ratelimiter.spring.boot.autoconfigure.annotations.GuavaRateLimiter;

@RestController
@RequestMapping("ratelimiter")
public class RateLimiterController {
	
	private final Logger logger = LoggerFactory.getLogger(RateLimiterController.class);
	
	@Resource
	private RestTemplate restTemplate;

	@GetMapping("index")
	@GuavaRateLimiter(permitsPerSecond = 1, exception = BaseRuntimeException.class)
	public ResultMap index(){
		logger.info("execute RateLimiterController method : index()");
		return ResultMap.buildSuccess();
	}
	
	@RequestMapping("/{name:.*}/{rate:.*}")
	public ResultMap set(@PathVariable String name, @PathVariable double rate){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("rate", String.valueOf(rate));
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		restTemplate.put("http://localhost:8080/limiter/" + name, request);
		return ResultMap.buildSuccess();
	}
	
}

package com.itopener.demo.redisson.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.demo.redisson.service.RedissonCacheableService;
import com.itopener.demo.redisson.vo.UserVO;
import com.itopener.framework.ResultMap;

/**  
 * @author fuwei.deng
 * @date 2018年1月10日 下午3:30:33
 * @version 1.0.0
 */
@RestController
@RequestMapping("redisson/cacheable")
public class RedissonCacheableController {
	
	@Resource
	private RedissonCacheableService redissonCacheableService;

	@GetMapping("{id}")
	public ResultMap get(@PathVariable long id) {
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO = redissonCacheableService.get(userVO);
		return ResultMap.buildSuccess().put("user", userVO);
	}
}

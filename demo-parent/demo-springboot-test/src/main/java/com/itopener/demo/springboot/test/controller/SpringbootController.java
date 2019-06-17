package com.itopener.demo.springboot.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;

/**
 * @author fuwei.deng
 * @date 2017年9月30日 下午3:04:28
 * @version 1.0.0
 */
@RestController
@RequestMapping("springboot")
public class SpringbootController {
	
	@GetMapping("index")
	public ResultMap index() {
		return ResultMap.buildSuccess().put("springbootresult", "spring boot test result value");
	}
	
}

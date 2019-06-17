package com.itopener.demo.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itopener.demo.dubbo.sdk.IUserService;
import com.itopener.demo.dubbo.sdk.dto.UserDTO;
import com.itopener.framework.ResultMap;

/**  
 * @author fuwei.deng
 * @date 2018年3月15日 下午6:09:33
 * @version 1.0.0
 */
@RestController
public class UserController {
	
	@Reference(version = "1.0.0", application = "${dubbo.application.id}")
	private IUserService userService;

	@GetMapping("user/{id}")
	public ResultMap user(@PathVariable long id) {
		UserDTO user = userService.get(id);
		return ResultMap.buildSuccess().put("user", user);
	}
}

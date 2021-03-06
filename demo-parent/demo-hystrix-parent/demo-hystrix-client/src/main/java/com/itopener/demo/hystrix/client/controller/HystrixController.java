package com.itopener.demo.hystrix.client.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.demo.hystrix.client.service.HystrtixService;
import com.itopener.framework.ResultMap;

/**  
 * @ClassName:RestController <br/> 
 * @Description <br/>
 * @date 2017年4月11日下午6:04:40 <br/>
 * @author fuwei.deng
 * @version 
 * @since JDK 1.6  
 * @see 
 */
@RestController
@RequestMapping("hystrix")
public class HystrixController {
	
	@Resource
	private HystrtixService hystrtixService;

	@RequestMapping("call/{id}")
	public ResultMap call(@PathVariable long id){
		return hystrtixService.call(id);
	}
}

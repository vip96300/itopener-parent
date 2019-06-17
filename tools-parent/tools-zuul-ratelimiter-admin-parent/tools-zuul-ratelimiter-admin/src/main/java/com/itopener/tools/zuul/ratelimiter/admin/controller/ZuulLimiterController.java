package com.itopener.tools.zuul.ratelimiter.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itopener.framework.ResultMap;
import com.itopener.tools.zuul.ratelimiter.admin.vo.ZuulRefreshVO;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 下午1:40:21
 * @version 1.0.0
 */
@RestController
@RequestMapping("zuul")
public class ZuulLimiterController {

	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("refresh")
	public ResultMap refresh(String zuulUrl) {
		if(StringUtils.isEmpty(zuulUrl)) {
			return ResultMap.buildFailed("请传入zuul地址");
		}
		Set<String> zuulUrls = new HashSet<>(Arrays.asList(zuulUrl.split(",")));
		List<ZuulRefreshVO> zuulRefreshs = new ArrayList<>();
		for(String url : zuulUrls) {
			ZuulRefreshVO zuulRefresh = new ZuulRefreshVO();
			zuulRefresh.setUrl(url);
			try {
				restTemplate.getForObject(url + "zuul_limiter/refresh", Map.class);
				zuulRefresh.setResult("刷新成功");
			} catch (Exception e) {
				zuulRefresh.setResult("刷新失败:" + e.getMessage());
			}
			zuulRefreshs.add(zuulRefresh);
		}
		
		return ResultMap.buildSuccess().put("refreshs", zuulRefreshs);
	}
}

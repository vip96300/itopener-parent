package com.itopener.demo.zuul.ratelimiter.db.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itopener.framework.ResultMap;
import com.itopener.zuul.ratelimiter.spring.boot.common.support.OverRateLimitException;

@Controller
@RequestMapping("/overlimit")
public class ZuulRateLimiterController {

	@RequestMapping(produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request) {
		// 取request中的错误码，SendErrorFilter中设置的值
		ModelAndView modelAndView = new ModelAndView(String.valueOf(request.getAttribute("javax.servlet.error.status_code")));
		OverRateLimitException exception = (OverRateLimitException) request.getAttribute("exception");
		ResultMap resultMap = ResultMap.buildFailed((String) request.getAttribute("javax.servlet.error.message"))
				.setCode(String.valueOf(request.getAttribute("javax.servlet.error.status_code")))
				.put("exp", exception.getLimiterEntity());
		
		modelAndView.addObject("data", resultMap);
		return modelAndView;
	}

	@RequestMapping
	@ResponseBody
	public ResultMap error(HttpServletRequest request) {
		OverRateLimitException exception = (OverRateLimitException) request.getAttribute("exception");
		return ResultMap.buildFailed((String) request.getAttribute("javax.servlet.error.message"))
				.setCode(String.valueOf(request.getAttribute("javax.servlet.error.status_code")))
				.put("exp", exception.getLimiterEntity());
	}

}

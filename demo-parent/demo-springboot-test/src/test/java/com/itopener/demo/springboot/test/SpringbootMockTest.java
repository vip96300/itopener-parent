package com.itopener.demo.springboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.itopener.demo.springboot.test.service.SpringbootService;
import com.itopener.demo.springboot.test.vo.User;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = { "dev" })
public class SpringbootMockTest {
	
	private final Logger logger = LoggerFactory.getLogger(SpringbootMockTest.class);

	@Resource
	private SpringbootService springbootService;
	
	@Test
	public void test() {
		User user = springbootService.getUser(1L);
		logger.info(JSON.toJSONString(user));
	}
}

package com.itopener.demo.springboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = { "dev" })
@AutoConfigureMockMvc
public class SpringbootMockMVCTest {
	
	private final Logger logger = LoggerFactory.getLogger(SpringbootMockMVCTest.class);

	@Resource
	private MockMvc mockMvc;
	
	@Test
	public void test() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/springboot/index").accept(MediaType.APPLICATION_JSON))
					.andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			logger.error("exception", e);
		}
	}
}

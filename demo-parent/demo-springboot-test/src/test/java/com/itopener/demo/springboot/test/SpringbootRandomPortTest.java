package com.itopener.demo.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = { "dev" })
public class SpringbootRandomPortTest {
	
	private final Logger logger = LoggerFactory.getLogger(SpringbootRandomPortTest.class);

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test() {
		String resultMap = restTemplate.getForObject("/springboot/index", String.class);
		logger.info(resultMap);
	}
}

package com.itopener.demo.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itopener.sequence.spring.boot.autoconfigure.support.IWorker;

/**
 * @author fuwei.deng
 * @date 2018年1月25日 下午4:27:51
 * @version 1.0.0
 */
@Configuration
public class SequenceConfiguration {
	
	@Bean
	public IWorker worker() {
		return new Worker();
	}
}

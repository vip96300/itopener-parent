package com.itopener.demo.redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author fuwei.deng
 * @date 2017年12月22日 上午10:25:05
 * @version 1.0.0
 */
@EnableCaching
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

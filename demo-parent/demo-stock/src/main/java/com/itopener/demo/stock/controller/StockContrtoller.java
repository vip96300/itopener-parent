package com.itopener.demo.stock.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;
import com.itopener.stock.spring.boot.autoconfigure.support.IStockCallback;
import com.itopener.stock.spring.boot.autoconfigure.support.Stock;

@RestController
@RequestMapping("stock")
public class StockContrtoller {
	
	private final Logger logger = LoggerFactory.getLogger(StockContrtoller.class);
	
	@Resource
	private Stock stock;
	
	@GetMapping("deduct/{key}/{deduct}")
	public ResultMap deduct(@PathVariable String key, @PathVariable long deduct){
		long result = stock.deduct(key, deduct, 60000, new IStockCallback() {
			@Override
			public long getStock(String key) {
				logger.info("get stock:{}", key);
				return 50;
			}
		});
		
		logger.info("deduct result : {}", result > -2);
		return ResultMap.buildSuccess().put("stock", result);
	}
	
	@GetMapping("restore/{key}/{restore}")
	public ResultMap restore(@PathVariable String key, @PathVariable long restore){
		long result = stock.restore(key, restore, 60000, new IStockCallback() {
			@Override
			public long getStock(String key) {
				logger.info("get stock:{}", key);
				return 50;
			}
		});
		
		logger.info("restore result : {}", result > -2);
		return ResultMap.buildSuccess().put("stock", result);
	}
	
}

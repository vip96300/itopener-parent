package com.itopener.demo.kafka.producer.controller;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.demo.kafka.producer.config.KafkaProducerConstant;
import com.itopener.framework.ResultMap;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {
	
	@Resource
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("send/{msg}")
	public ResultMap send(@PathVariable String msg){
		kafkaTemplate.send(KafkaProducerConstant.KAFKA_TOPIC_ITOPENER_DEMO, msg);
		return ResultMap.buildSuccess();
	}
}

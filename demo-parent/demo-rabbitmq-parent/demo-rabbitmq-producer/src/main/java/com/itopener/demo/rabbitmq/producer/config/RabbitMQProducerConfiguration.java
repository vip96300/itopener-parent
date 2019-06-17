package com.itopener.demo.rabbitmq.producer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
@Configuration
public class RabbitMQProducerConfiguration {
	
	private final Logger logger = LoggerFactory.getLogger(RabbitMQProducerConfiguration.class);

	/**
	 * @description 动态声明queue、exchange、routing
	 * @author fuwei.deng
	 * @date 2017年7月19日 下午4:18:33
	 * @version 1.0.0
	 * @param connectionFactory
	 * @return
	
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		Queue queue = new Queue(RabbitMQProducerConstant.QUEUE_ITOPENER);
		DirectExchange exchange = new DirectExchange(RabbitMQProducerConstant.EXCHANGE_ITOPENER);
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareExchange(exchange);
		rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(RabbitMQProducerConstant.ROUTINGKEY_ITOPENER));
		return rabbitAdmin;
	} */
	
	@Bean
	public ConfirmCallback confirmCallback(RabbitTemplate rabbitTemplate) {
		ConfirmCallback confirmCallback = new ConfirmCallback() {
			
			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				logger.info("{}=={}=={}", correlationData.getId(), ack, cause);
			}
		};
		
		rabbitTemplate.setConfirmCallback(confirmCallback);
		return confirmCallback;
	}
	
	@Bean
	public ReturnCallback returnCallback(RabbitTemplate rabbitTemplate) {
		ReturnCallback returnCallback = new ReturnCallback() {

			@Override
			public void returnedMessage(Message message, int replyCode, String replyText, String exchange,
					String routingKey) {
				logger.info("{}=={}=={}=={}=={}", JSON.toJSONString(rabbitTemplate.getMessageConverter().fromMessage(message)), replyCode, replyText, exchange, routingKey);
			}
			
		};
		rabbitTemplate.setReturnCallback(returnCallback);
		return returnCallback;
	}
}

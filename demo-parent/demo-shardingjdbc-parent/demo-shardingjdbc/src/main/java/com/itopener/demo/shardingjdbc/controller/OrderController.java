package com.itopener.demo.shardingjdbc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.demo.shardingjdbc.conditions.OrderCondition;
import com.itopener.demo.shardingjdbc.conditions.OrderItemCondition;
import com.itopener.demo.shardingjdbc.model.Order;
import com.itopener.demo.shardingjdbc.model.OrderItem;
import com.itopener.demo.shardingjdbc.service.OrderItemService;
import com.itopener.demo.shardingjdbc.service.OrderService;
import com.itopener.demo.shardingjdbc.service.SerialIdService;
import com.itopener.framework.ResultMap;
import com.itopener.utils.TimestampUtil;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
@RestController
@RequestMapping("order")
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private OrderItemService orderItemService;
	
	@Resource
	private SerialIdService serialIdService;
	
	@PostMapping("{userId}")
	public ResultMap add(@PathVariable long userId){
		for(long i = 0; i<10; i++) {
			Order order = new Order();
			order.setId(serialIdService.getSerialId());
//			order.setId(i + 1);
			order.setState(new Random().nextInt(5) + 1);
			order.setUserId(userId);
			order.setUpdateTime(TimestampUtil.current());
			order.setOrderItemList(new ArrayList<>());
			for(long j = 0; j<new Random().nextInt(100) % 3 + 1; j++) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(serialIdService.getSerialId());
				orderItem.setOrderId(order.getId());
				orderItem.setState(order.getState());
				orderItem.setUserId(userId);
				orderItem.setUpdateTime(order.getUpdateTime());
				order.getOrderItemList().add(orderItem);
			}
			orderService.add(order);
		}
		return ResultMap.buildSuccess();
	}
	
	@PutMapping("{userId}/{orderId}")
	public ResultMap update(@PathVariable long userId, @PathVariable long orderId){
		Order order = new Order();
		order.setId(orderId);
		order.setState(new Random().nextInt(10));
		order.setUserId(userId);
		order.setUpdateTime(TimestampUtil.current());
		order.setOrderItemList(new ArrayList<>());
		
		OrderItemCondition condition = new OrderItemCondition();
		condition.setOrderId(orderId);
		List<OrderItem> orderItemList = orderItemService.select(condition);
		for(int i = 0; i<orderItemList.size(); i++) {
			orderItemList.get(i).setState(new Random().nextInt(10));
			orderItemList.get(i).setUpdateTime(order.getUpdateTime());
			order.getOrderItemList().add(orderItemList.get(i));
		}
		
		orderService.update(order);
		return ResultMap.buildSuccess();
	}
	
	@GetMapping("{userId}")
	public ResultMap get(@PathVariable long userId){
		OrderCondition orderCondition = new OrderCondition();
		orderCondition.setUserId(userId);
		List<Order> orderList = orderService.select(orderCondition);
		
		OrderItemCondition orderItemCondition = new OrderItemCondition();
		for(Order order : orderList) {
			orderItemCondition.setOrderId(order.getId());
			order.setOrderItemList(orderItemService.select(orderItemCondition));
		}
		
		return ResultMap.buildSuccess().put("orders", orderList);
	}
	
	@GetMapping("{userId}/{orderId}")
	public ResultMap get(@PathVariable long userId, @PathVariable long orderId){
		Order order = orderService.selectById(orderId);
		if(order != null) {
			OrderItemCondition orderItemCondition = new OrderItemCondition();
			orderItemCondition.setOrderId(order.getId());
			order.setOrderItemList(orderItemService.select(orderItemCondition));
		}
		
		return ResultMap.buildSuccess().put("order", order);
	}

	@DeleteMapping("{userId}/{orderId}")
	public ResultMap delete(@PathVariable long userId, @PathVariable long orderId){
		Order order = new Order();
		order.setId(orderId);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(orderId);
		orderService.delete(order, orderItem);
		return ResultMap.buildSuccess();
	}
}

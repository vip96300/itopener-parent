package com.itopener.demo.springboot.test.service;

import org.springframework.stereotype.Service;

import com.itopener.demo.springboot.test.vo.User;

@Service
public class SpringbootService {

	public User getUser(long id) {
		User user = new User();
		user.setId(id);
		user.setName("name" + id);
		return user;
	}
}

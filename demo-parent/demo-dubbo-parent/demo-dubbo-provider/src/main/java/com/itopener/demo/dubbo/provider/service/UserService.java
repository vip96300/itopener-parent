package com.itopener.demo.dubbo.provider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.itopener.demo.dubbo.sdk.IUserService;
import com.itopener.demo.dubbo.sdk.dto.UserDTO;
import com.itopener.utils.TimestampUtil;

/**  
 * @author fuwei.deng
 * @date 2018年3月15日 下午4:48:58
 * @version 1.0.0
 */
@Service(version = "1.0.0", application = "${dubbo.application.id}", protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class UserService implements IUserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public UserDTO get(long id) {
		logger.info("get user of id : {}", id);
		UserDTO user = new UserDTO();
		user.setId(id);
		user.setName("dubbo" + id);
		user.setCreateTime(TimestampUtil.current());
		return user;
	}

}

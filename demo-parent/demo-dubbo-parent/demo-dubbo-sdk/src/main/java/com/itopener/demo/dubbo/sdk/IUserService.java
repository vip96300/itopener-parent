package com.itopener.demo.dubbo.sdk;

import com.itopener.demo.dubbo.sdk.dto.UserDTO;

/**  
 * @author fuwei.deng
 * @date 2018年3月15日 下午4:48:58
 * @version 1.0.0
 */
public interface IUserService {

	public UserDTO get(long id);
}

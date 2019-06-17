package com.itopener.tools.zuul.ratelimiter.admin.enums;

/**  
 * @author fuwei.deng
 * @date 2018年2月5日 下午3:06:52
 * @version 1.0.0
 */
public enum EnableEnum {

	ENABLE(true, "启用"),
	DISABLE(false, "禁用");
	
	private boolean enable;
	
	private String name;

	private EnableEnum(boolean enable, String name) {
		this.enable = enable;
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public String getName() {
		return name;
	}
	
}

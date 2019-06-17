package com.itopener.framework.base;

import java.util.Collection;
import java.util.regex.Pattern;

import org.springframework.util.CollectionUtils;

public class Assert {

	/**
	 * @description 对象不为空
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:26:24
	 * @version 1.0.0
	 * @param msg
	 * @param obj
	 */
	public static void notNull(String msg, Object obj){
		if(obj == null){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 字符串不为空
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:25:33
	 * @version 1.0.0
	 * @param msg
	 * @param str
	 */
	public static void notEmpty(String msg, String str){
		if(str == null || str.trim().length() < 1){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 全部不为空
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:26:59
	 * @version 1.0.0
	 * @param msg
	 * @param strs
	 */
	public static void notEmptyAll(String msg, String... strs){
		for(String str : strs){
			notEmpty(msg, str);
		}
	}
	
	/**
	 * @description 至少一个不为空
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:07
	 * @version 1.0.0
	 * @param msg
	 * @param strs
	 */
	public static void notEmptyAtLeastOne(String msg, String... strs){
		for(String str : strs){
			if(str != null && str.trim().length() > 0){
				return ;
			}
		}
		throw new BaseRuntimeException(msg);
	}
	
	/**
	 * @description 正整数
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:21
	 * @version 1.0.0
	 * @param msg
	 * @param integer
	 */
	public static void positiveInteger(String msg, Integer integer){
		if(integer == null || integer <= 0){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 正整数
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:29
	 * @version 1.0.0
	 * @param msg
	 * @param integer
	 */
	public static void positiveInteger(String msg, int integer){
		if(integer <= 0){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 正长整型数
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:37
	 * @version 1.0.0
	 * @param msg
	 * @param l
	 */
	public static void positiveLong(String msg, Long l){
		if(l == null || l <= 0){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 正长整型数
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:44
	 * @version 1.0.0
	 * @param msg
	 * @param l
	 */
	public static void positiveLong(String msg, long l){
		if(l <= 0){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 字符串为空或不一样
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:51
	 * @version 1.0.0
	 * @param msg
	 * @param arg1
	 * @param arg2
	 */
	public static void equal(String msg, String arg1, String arg2){
		if(arg1 == null || arg2 == null || !arg1.equals(arg2)){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 数字不相等
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:27:58
	 * @version 1.0.0
	 * @param msg
	 * @param arg1
	 * @param arg2
	 */
	public static void same(String msg, int arg1, int arg2){
		if(arg1 != arg2){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 集合不为空
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:28:04
	 * @version 1.0.0
	 * @param msg
	 * @param c
	 */
	public static void notEmpty(String msg, Collection<?> c){
		if(CollectionUtils.isEmpty(c)){
			throw new BaseRuntimeException(msg);
		}
	}
	
	/**
	 * @description 手机号验证
	 * @author fuwei.deng
	 * @date 2017年12月7日 下午3:28:20
	 * @version 1.0.0
	 * @param msg
	 * @param phone
	 */
	public static void isPhone(String msg, String phone){
		boolean isPhone = Pattern.matches("^(1)\\d{10}$", phone);
		if(!isPhone){
			throw new BaseRuntimeException(msg);
		}
	}
}

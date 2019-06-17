package com.itopener.demo.sequence.config;

import com.itopener.sequence.spring.boot.autoconfigure.support.IWorker;

/**  
 * @author fuwei.deng
 * @date 2018年1月25日 下午4:31:13
 * @version 1.0.0
 */
public class Worker implements IWorker {

	@Override
	public long getId() {
		return 1;
	}

}

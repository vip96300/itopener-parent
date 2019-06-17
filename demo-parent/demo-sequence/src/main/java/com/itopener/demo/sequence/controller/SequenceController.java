package com.itopener.demo.sequence.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;
import com.itopener.sequence.spring.boot.autoconfigure.support.Sequence;

/**
 * @author fuwei.deng
 * @date 2018年1月25日 下午4:29:27
 * @version 1.0.0
 */
@RestController
@RequestMapping("sequence")
public class SequenceController {
	
	@Resource
	private Sequence sequence;

	@GetMapping("generate")
	public ResultMap generate() {
		AtomicLong atomicLong = new AtomicLong();
		Set<Long> sequences = Collections.synchronizedSet(new HashSet<>());
		
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					long start = System.currentTimeMillis();
					while ((System.currentTimeMillis() - start) < 10 * 1000) {
//						long id = sequence.get();
//						sequences.add(id);
						sequence.get();
						atomicLong.incrementAndGet();
					}
				}
			}).start();
		}
		
		try {
			Thread.sleep(1000 * 15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(atomicLong.get() + "===" + sequences.size());
		return ResultMap.buildSuccess().put("atomic", atomicLong.get()).put("sequences", sequences);
	}
}

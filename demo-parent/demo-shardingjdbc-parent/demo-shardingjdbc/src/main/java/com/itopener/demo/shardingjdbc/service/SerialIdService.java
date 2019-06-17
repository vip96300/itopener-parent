package com.itopener.demo.shardingjdbc.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.itopener.demo.shardingjdbc.config.IpUtils;
import com.itopener.demo.shardingjdbc.dao.SysIpDao;
import com.itopener.demo.shardingjdbc.model.SysIp;
import com.itopener.utils.TimestampUtil;

@Service
public class SerialIdService {

	private static Logger logger = LoggerFactory.getLogger(SerialIdService.class);

	@Resource
	private SysIpDao sysIpDao;

	private long workId;

	private long dataCenterId;
	
	private SequenceWorker sequenceWorker;
	
	@Value("${server.port}")
	private String port;

	public long getSerialId() {
		long start = System.currentTimeMillis();
		createSequenceWorker();
		long id = sequenceWorker.nextId();
		logger.info("生成的流水ID=" + id + ",耗时毫秒：" + (System.currentTimeMillis() - start));
		return id;
	}

	private void createSequenceWorker() {
		if(sequenceWorker != null) {
			return ;
		}
		if (workId < 1 || dataCenterId < 1) {
			SysIp sysIp = null;
			String ipport = IpUtils.getLocalIP() + ":" + port;
			List<SysIp> sysIpList = sysIpDao.selectByIpAddress(ipport);
			if (CollectionUtils.isEmpty(sysIpList)) {
				sysIp = new SysIp();
				sysIp.setCreateTime(TimestampUtil.current());
				sysIp.setDataCenterId(1);
				sysIp.setIpAddress(ipport);
				sysIpDao.insert(sysIp);
			} else {
				sysIp = sysIpList.get(0);
			}
			workId = sysIp.getId();
			dataCenterId = sysIp.getDataCenterId();
		}
		sequenceWorker = new SequenceWorker(workId % (SequenceWorker.maxWorkerId + 1), dataCenterId);
	}
}

package com.itopener.demo.shardingjdbc.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.PageHelper;

import com.itopener.framework.base.BaseDao;
import com.itopener.demo.shardingjdbc.model.SysIp;
import com.itopener.demo.shardingjdbc.conditions.OrderCondition;

@Repository
public class SysIpDao {

	private final String NAMESPACE = "com.itopener.demo.shardingjdbc.mapper.SysIpMapper.";

	@Resource
	private BaseDao baseDao;

	public int insert(SysIp sysIp) {
		return baseDao.insert(NAMESPACE + "insert", sysIp);
	}

	public List<SysIp> selectList(OrderCondition condition) {
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public List<SysIp> selectPage(OrderCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getSize(), false);
		return baseDao.selectList(NAMESPACE + "select", condition);
	}

	public long selectCount(OrderCondition condition) {
		return baseDao.selectOne(NAMESPACE + "selectCount", condition);
	}

	public SysIp selectOne(OrderCondition condition) {
		return baseDao.selectOne(NAMESPACE + "select", condition);
	}

	public SysIp selectById(long id) {
		return baseDao.selectOne(NAMESPACE + "selectById", id);
	}
	
	public List<SysIp> selectByIpAddress(String ipAddress) {
		return baseDao.selectList(NAMESPACE + "selectByIpAddress", ipAddress);
	}

	public int update(SysIp sysIp) {
		return baseDao.update(NAMESPACE + "update", sysIp);
	}

	public int delete(SysIp sysIp) {
		return baseDao.update(NAMESPACE + "delete", sysIp);
	}

}
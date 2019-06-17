package com.itopener.framework.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**  
 * @author fuwei.deng
 * @Date 2017年6月9日 下午3:10:58
 * @version 1.0.0
 */
public class CommonDao {
	
	private final static String SQL_INSERT = "insert";
	
	private final static String SQL_UPDATE = "update";
	
	private final static String SQL_SELECT = "select";
	
	private final static String SQL_COUNT = "count";
	
	private final static String SQL_DELETE = "delete";
	
	private final static String SQL_SELECT_BY_ID = "selectById";
	
	@Resource
	protected BaseDao baseDao;
	
	protected String sqlId;
	
	public CommonDao() {
		super();
	}

	public CommonDao(String sqlId) {
		super();
		this.sqlId = sqlId;
	}

	public int delete(Object object) {
		return baseDao.delete(sqlId + SQL_DELETE, object);
	}
	
	public int insert(Object object) {
		return baseDao.insert(sqlId + SQL_INSERT, object);
	}
	
	public <T> List<T> selectList(Object object) {
		return baseDao.selectList(sqlId + SQL_SELECT, object);
	}
	
	public <T> T selectById(Object id) {
		return baseDao.selectOne(sqlId + SQL_SELECT_BY_ID, id);
	}

	public <T> List<T> selectPage(BaseCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getSize(), false);
		return baseDao.selectList(sqlId + SQL_SELECT, condition);
	}
	
	public long count(BaseCondition condition) {
		return baseDao.selectOne(sqlId + SQL_COUNT, condition);
	}
	
	public <T> T selectOne(Object object) {
		return baseDao.selectOne(sqlId + SQL_SELECT, object);
	}
	
	public <T> T selectOnePage(BaseCondition condition) {
		condition.setPage(1);
		condition.setSize(1);
		List<T> list = this.selectPage(condition);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
	
	public int update(Object object) {
		return baseDao.update(sqlId + SQL_UPDATE, object);
	}
}


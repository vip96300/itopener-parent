package com.itopener.framework.base;

import java.util.List;

public abstract class AbstractService<T> {
	
	protected abstract CommonDao getDao();
	
	public int insert(T t) {
		return getDao().insert(t);
	}

	public List<T> selectList(BaseCondition condition) {
		return getDao().selectList(condition);
	}
	
	public T selectById(Object id) {
		return getDao().selectById(id);
	}

	public List<T> selectPage(BaseCondition condition) {
		return getDao().selectPage(condition);
	}

	public long count(BaseCondition condition) {
		return getDao().count(condition);
	}

	public T selectOne(BaseCondition condition) {
		return getDao().selectOne(condition);
	}

	public int update(T t) {
		return getDao().update(t);
	}

	public int delete(T t) {
		return getDao().delete(t);
	}
	
	public List<T> all(){
		return getDao().selectList(null);
	}
	
	public PageResult<T> page(BaseCondition condition) {
		PageResult<T> pageResult = new PageResult<T>();
		long count = getDao().count(condition);
		List<T> list = null;
		if(count > 0) {
			list = getDao().selectPage(condition);
		}
		pageResult.setCount(count);
		pageResult.setList(list);
		return pageResult;
	}
}

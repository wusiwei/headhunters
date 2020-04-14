package com.lietou.common;


public interface BaseBLOBMapper<T> {

	int insert(T t);
	
	int deleteByPrimaryKey(Long id);
	
    int insertSelective(T t);

    T selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
    
    int updateByPrimaryKeyWithBLOBs(T t);
}

package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpType;

/**
 * CpTypeDAO继承基类
 */
@Repository
public interface CpTypeDAO extends MyBatisBaseDao<CpType, Integer> {
	CpType getBeanByName(String name);
	
	List<CpType> getList();
}
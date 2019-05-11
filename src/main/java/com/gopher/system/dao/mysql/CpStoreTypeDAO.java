package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpStoreType;

/**
 * CpStoreTypeDAO继承基类
 */
@Repository
public interface CpStoreTypeDAO extends MyBatisBaseDao<CpStoreType, Integer> {
	CpStoreType getBeanByOutKey(CpStoreType cpStoreType);
}
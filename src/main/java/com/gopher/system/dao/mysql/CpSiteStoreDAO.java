package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpSiteStore;

/**
 * CpSiteStoreDAO继承基类
 */
@Repository
public interface CpSiteStoreDAO extends MyBatisBaseDao<CpSiteStore, Integer> {
	CpSiteStore getBeanByOutKey(CpSiteStore cp);
}
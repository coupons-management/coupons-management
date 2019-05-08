package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpSiteStore;
import org.springframework.stereotype.Repository;

/**
 * CpSiteStoreDAO继承基类
 */
@Repository
public interface CpSiteStoreDAO extends MyBatisBaseDao<CpSiteStore, Integer> {
	
	CpSiteStore getBeanByOutKey(CpSiteStore cp);
}
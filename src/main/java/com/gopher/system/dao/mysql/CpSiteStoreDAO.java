package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpSiteStore;

/**
 * CpSiteStoreDAO继承基类
 * 爬虫站的关系
 */
@Repository
public interface CpSiteStoreDAO extends MyBatisBaseDao<CpSiteStore, Integer> {
	
	CpSiteStore getBeanByOutKey(CpSiteStore cp);
	
	List<CpSiteStore> getList(CpSiteStore cpSiteStore);
}
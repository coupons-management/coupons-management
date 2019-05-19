package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpSitestoreTypeMap;

/**
 * CpSitestoreTypeMapDAO继承基类
 */
@Repository
public interface CpSitestoreTypeMapDAO extends MyBatisBaseDao<CpSitestoreTypeMap, Integer> {
	
	void deleteBySiteTypeId(final int siteTypeId);
	
	List<CpSitestoreTypeMap> getListBySite(final int outSiteId);
	
}
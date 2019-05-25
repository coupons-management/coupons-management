package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSiteStore;

public interface StoreAuditService {
/**
 * 加入站点操作	
 * @param cpSiteStore
 */
void addSite(CpOutSiteStore cpOutSiteStore);
/**
 * 查询所有站点
 * @return
 */
List<CpOutSiteStore> getOutSitleList(CpOutSiteStore cpOutSiteStore);

}

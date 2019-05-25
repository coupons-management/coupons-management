package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSiteStore;


public interface StoreAuditService {
/**
 * 加入站点操作	
 * @param cpSiteStore
 */
void addSite(CpOutSiteStore cpOutSiteStore);

/**
 * 修改热门排序
 * @param cpSiteStore
 */
void updateHotSort(CpOutSiteStore cpOutSiteStore);
/**
 * 修改热门推荐
 * @param cpSiteStore
 */
void updateAdviseSort(CpOutSiteStore cpOutSiteStore);

/**
 *删除热门排序
 * @param cpSiteStore
 */
void deleteHotSort(CpOutSiteStore cpOutSiteStore);

/**
 *删除热门推荐
 * @param cpSiteStore
 */
void deleteAdviseSort(CpOutSiteStore cpOutSiteStore);


/**
 * 查询所有站点
 * @return
 */
List<CpOutSiteStore> getOutSitleList(CpOutSiteStore cpOutSiteStore);

}

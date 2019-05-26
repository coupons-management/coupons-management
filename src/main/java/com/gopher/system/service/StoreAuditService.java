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

/**
 * 查询热门商家列表
 * @return
 */
List<CpOutSiteStore> getHotStoreList(CpOutSiteStore cpOutSiteStore);

/**
 * 查询推荐商家列表
 * @return
 */
List<CpOutSiteStore> getAdviseStroreList(CpOutSiteStore cpOutSiteStore);

/**
 * 查询热门商家列表前10
 * @return
 */
List<CpOutSiteStore> getTopHotStoreList(CpOutSiteStore cpOutSiteStore);

/**
 * 查询推荐商家列表前10
 * @return
 */
List<CpOutSiteStore> getTopAdviseStroreList(CpOutSiteStore cpOutSiteStore);






}

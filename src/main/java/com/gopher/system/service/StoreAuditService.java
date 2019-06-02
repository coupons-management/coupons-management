package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.request.StoreSortRequest;


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
 * 批量修改
 * @param storeSortRequest
 */
void updateHotSort(StoreSortRequest storeSortRequest);
/**
 * 修改热门推荐
 * @param cpSiteStore
 */
void updateAdviseSort(CpOutSiteStore cpOutSiteStore);
/**
 * 批量
 * @param cpOutSiteStore
 */
void updateAdviseSort(StoreSortRequest storeSortRequest);
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
Page<CpOutSiteStore> getHotStoreList(ShowSiteStoreRequest cpOutSiteStore);

/**
 * 查询推荐商家列表
 * @return
 */
Page<CpOutSiteStore> getAdviseStroreList(ShowSiteStoreRequest cpOutSiteStore);

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

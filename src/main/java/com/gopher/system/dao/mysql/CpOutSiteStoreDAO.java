package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpOutSiteStore;

/**
 * CpOutSiteStoreDAO继承基类
 */
@Repository
public interface CpOutSiteStoreDAO extends MyBatisBaseDao<CpOutSiteStore, Integer> {
	
	List<CpOutSiteStore> getList(CpOutSiteStore  cpOutSiteStore);
	
	void deleteByBean(CpOutSiteStore cpOutSiteStore);
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
	 * 查询热门商家列表
	 * @return
	 */
	List<CpOutSiteStore> getOutSitleHotList(CpOutSiteStore cpOutSiteStore);

	/**
	 * 查询推荐商家列表
	 * @return
	 */
	List<CpOutSiteStore> getOutSitleAdviseList(CpOutSiteStore cpOutSiteStore);

}
package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.StoreAllPageRequst;
import com.gopher.system.model.vo.request.StorePageRequst;

/**
 * CpStoreDAO继承基类
 */
@Repository
public interface CpStoreDAO extends MyBatisBaseDao<CpStore, Integer> {
	public CpStore getBeanByWebSite(String website);

	/**
	 * 获得分页列表
	 * 
	 * @param storePageRequest
	 * @return
	 */
	List<CpStore> getPageList(StorePageRequst storePageRequest);

	/**
	 * 获得总数
	 * 
	 * @param storePageRequest
	 * @return
	 */
	int getCount(StorePageRequst storePageRequest);	
	
	/**
	 * 获得爬虫商家分页列表
	 * 
	 * @param storePageRequest
	 * @return
	 */
	List<StoreAllPageRequst> getScrapyPageList(StoreAllPageRequst storeAllPageRequst);

	/**
	 * 获得爬虫总数
	 * 
	 * @param storePageRequest
	 * @return
	 */
	int getScrapyCount(StoreAllPageRequst storeAllPageRequst);	
	
	
	/**
	 * 获得爬虫商家分页列表
	 * 
	 * @param storePageRequest
	 * @return
	 */
	List<StoreAllPageRequst> getErrScrapyPageList(StoreAllPageRequst storeAllPageRequst);

	/**
	 * 获得爬虫总数
	 * 
	 * @param storePageRequest
	 * @return
	 */
	int getErrScrapyCount(StoreAllPageRequst storeAllPageRequst);	
	/**
	 * 修改商家logo
	 * @param website
	 * @return
	 */
	 void updateLogo(CpStore website);
	 List<CpStore> getOffWebStorePageList(StorePageRequst quest);
	 int getOffWebTotalCount(StorePageRequst quest);
	 
	 List<CpStore> getTopStoreList(CpSitestoreRequest quest);
	
}


package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.vo.request.*;
import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.CpStoreVo;

/**
 * CpStoreDAO继承基类
 */
@Repository
public interface CpStoreDAO extends MyBatisBaseDao<CpStore, Integer> {

	 CpStore getBeanByWebSite(String website);

	 CpStore findByWebsite(StoreDetailJspRequest request);

	/**
	 * 根据爬虫ID 获取商家列表
	 * @param spiderId
	 * @return
	 */
	 List<CpStore> getListBySpider(int spiderId);

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
	 * @param storeAllPageRequst
	 * @return
	 */
	List<StoreAllPageRequst> getScrapyPageList(StoreAllPageRequst storeAllPageRequst);

	/**
	 * 获得爬虫总数
	 * 
	 * @param storeAllPageRequst
	 * @return
	 */
	int getScrapyCount(StoreAllPageRequst storeAllPageRequst);	
	
	
	/**
	 * 获得爬虫商家分页列表
	 * 
	 * @param storeAllPageRequst
	 * @return
	 */
	List<StoreAllPageRequst> getErrScrapyPageList(StoreAllPageRequst storeAllPageRequst);

	/**
	 * 获得爬虫总数
	 * 
	 * @param storeAllPageRequst
	 * @return
	 */
	int getErrScrapyCount(StoreAllPageRequst storeAllPageRequst);	
	/**
	 * 修改商家logo
	 * @param website
	 * @return
	 */
	 void updateLogo(CpStore website);

	 List<CpStoreVo> getOffWebStorePageList(StorePageRequst quest);

	 int getOffWebTotalCount(StorePageRequst quest);

	/**
	 *
	 * @param quest
	 * @return
	 */
	 List<CpStoreVo> getTopStoreList(CpSitestoreRequest quest);


	/**
	 * 可分配商家列表
	 * @return
	 */
	List<CpStore> availableAssignStore(StoreAvailableRequet storeAvailableRequet);

	/**
	 * 可分配商家总数
	 * @return
	 */
	int availableAssignStoreCount(StoreAvailableRequet storeAvailableRequet);
	
}


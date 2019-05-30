package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.request.StoreVerifyRequest;
import com.gopher.system.model.vo.response.StoreResponse;

public interface StoreService {

	Page<StoreResponse> getPage(StorePageRequst storeRequest);

	void edit(CpStore cpStore);

	void verifyBatch(StoreVerifyRequest storeVerifyRequest);

	/**
	 * 获取商家在展示站点名称
	 * 
	 * @param storeId
	 * @return
	 */
	List<String> getInShowSiteNameList(int storeId);

	/**
	 * 获取商家来源爬虫站点名称
	 * 
	 * @param storeId
	 * @return
	 */
	List<String> getSpiderSiteNameList(int storeId);

}

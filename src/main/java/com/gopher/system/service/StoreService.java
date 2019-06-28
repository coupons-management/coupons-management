package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.request.StoreVerifyRequest;
import com.gopher.system.model.vo.response.StoreResponse;

public interface StoreService {
	/**
	 * 分页
	 * @param storeRequest
	 * @return
	 */
	Page<StoreResponse> getPage(StorePageRequst storeRequest);

	/**
	 * 编辑
	 * @param cpStore
	 */
	void edit(CpStore cpStore);

	/**
	 * 批量审核
	 * @param storeVerifyRequest
	 */
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

	/**
	 * 设置商家页面展示信息
	 * @param list
	 * @return
	 */
	List<StoreResponse> getShowValue(List<CpStore> list);



}

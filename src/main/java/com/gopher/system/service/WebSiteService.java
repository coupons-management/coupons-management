package com.gopher.system.service;

import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.model.vo.response.StoreDetailResponse;

public interface WebSiteService {
	/**
	 * 获取当前类型下的所有优惠券
	 * @return
	 */
	Page<CpCouponVo> getCouponListByCategory(CategoryRequest categoryRequest);

	/**
	 * 获取商家详情 商家信息 和商家下下所有的优惠券列表
	 * @param storeRequest
	 * @return
	 */
	StoreDetailResponse getStoreDetail(StoreRequest storeRequest);

	/**
	 * 更新优惠券点击次数
	 */
	void updateCouponClickCount(CpCouponVo cpCouponVo);

	/**
	 * 更新商家访问次数
	 */
	void updateStoreVisitCount(StoreRequest storeRequest);
	
	
	
}

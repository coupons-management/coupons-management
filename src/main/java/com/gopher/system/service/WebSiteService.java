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
	
	StoreDetailResponse getStoreDetail(StoreRequest storeRequest);
	
	
	
}

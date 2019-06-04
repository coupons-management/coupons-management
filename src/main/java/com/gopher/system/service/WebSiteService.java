package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.model.vo.response.StoreDetailResponse;

public interface WebSiteService {
	/**
	 * 获取当前类型下的所有优惠券
	 * @return
	 */
	List<CpCouponVo> getCouponListByCategory(CategoryRequest categoryRequest);
	
	StoreDetailResponse getStoreDetail(StoreRequest storeRequest);
}

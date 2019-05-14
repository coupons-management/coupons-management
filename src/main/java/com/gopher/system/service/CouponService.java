package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.response.CouponResponse;

public interface CouponService {
	/**
	 * 获取系统优惠券分页列表
	 * @param couponPageRequest
	 * @return
	 */
	Page<CouponResponse> getPage(CouponPageRequest couponPageRequest);
	/**
	 * 获取当前商家的所有优惠券数量
	 * @param storeId
	 * @return
	 */
	public int getTotalCountByStore(final int storeId);
	/**
	 * 获取当前商家有效的优惠券数量
	 * @param storeId
	 * @return
	 */
	public int getValidCountByStore(final int storeId) ;

}

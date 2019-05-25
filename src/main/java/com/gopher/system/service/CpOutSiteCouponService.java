package com.gopher.system.service;

import com.gopher.system.model.entity.CpOutSiteCoupon;

public interface CpOutSiteCouponService {
	/**
	 * 修改热门排序
	 * @param cpSiteStore
	 */
	void updateHotSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 * 修改热门推荐
	 * @param cpSiteStore
	 */
	void updateAdviseSort(CpOutSiteCoupon cpOutSiteCoupon);
	
	/**
	 * 删除热门排序
	 * @param cpSiteStore
	 */
	void deleteHotSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 *  删除热门推荐
	 * @param cpSiteStore
	 */
	void deleteAdviseSort(CpOutSiteCoupon cpOutSiteCoupon);

}

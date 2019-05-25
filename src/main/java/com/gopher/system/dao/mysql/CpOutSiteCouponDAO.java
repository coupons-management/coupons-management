package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpOutSiteCoupon;

import org.springframework.stereotype.Repository;

/**
 * CpOutSiteCouponDAO继承基类
 */
@Repository
public interface CpOutSiteCouponDAO extends MyBatisBaseDao<CpOutSiteCoupon, Integer> {
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

	void deleteByBean(CpOutSiteCoupon cpOutSiteCoupon);
}
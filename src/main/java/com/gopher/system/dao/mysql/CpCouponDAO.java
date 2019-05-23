package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.request.CouponPageRequest;

/**
 * CpCouponDAO继承基类
 */
@Repository
public interface CpCouponDAO extends MyBatisBaseDao<CpCoupon, Integer> {
	CpCoupon getBeanByName(CpCoupon cou);
	
	List<CpCoupon> getPageList(CouponPageRequest couponPageRequest);
	
	int getCount(CouponPageRequest couponPageRequest);
	
	List<CpCoupon> getList(CpCoupon coupon);
}
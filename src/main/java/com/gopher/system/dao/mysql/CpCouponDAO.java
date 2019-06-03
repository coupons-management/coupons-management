package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.worker.vo.SpiderStatisticVO;

/**
 * CpCouponDAO继承基类
 */
@Repository
public interface CpCouponDAO extends MyBatisBaseDao<CpCoupon, Integer> {

	CpCoupon getBeanByName(CpCoupon cou);

	List<CpCoupon> getPageList(CouponPageRequest couponPageRequest);

	int getCount(CouponPageRequest couponPageRequest);

	List<CpCoupon> getList(CpCoupon coupon);

	CpCoupon getNewOneByStore(Integer storeId);

	int getCountBySpiderAndTime(SpiderStatisticVO spiderStatisticVO);

	List<CpCoupon> getScapyPageList(CouponPageRequest couponPageRequest);

	int getScapyCount(CouponPageRequest couponPageRequest);

	List<CpCoupon> getErrScapyPageList(CouponPageRequest couponPageRequest);

	int getErrScapyCount(CouponPageRequest couponPageRequest);

	public List<CpCouponVo> getOffWebCouponPageList(CouponPageRequest quest);

	int getOffWebTotalCount(CouponPageRequest quest);

	List<CpCouponVo> getTopCouponList(CouponPageRequest quest);
	
	List<CpCouponVo> getStoreExpCouponList(CouponPageRequest quest);
	List<CpCouponVo> getStoreCouponList(CouponPageRequest quest);
	List<CpCouponVo> getStoreCategoryCouponList(CouponPageRequest quest);
	
	
	
	
	
	
	
}
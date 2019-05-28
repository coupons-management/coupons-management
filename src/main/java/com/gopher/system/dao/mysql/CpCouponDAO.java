package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpCoupon;
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
	
	CpCoupon getNewOneByStore(int storeId);
	
	int getCountBySpiderAndTime(SpiderStatisticVO spiderStatisticVO);
}
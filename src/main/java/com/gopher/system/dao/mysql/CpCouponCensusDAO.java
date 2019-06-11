package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpCouponCensus;
import com.gopher.system.util.SpiderStatusJson;
import org.springframework.stereotype.Repository;

/**
 * CpCouponCensusDAO继承基类
 */
@Repository
public interface CpCouponCensusDAO extends MyBatisBaseDao<CpCouponCensus, Integer> {
	CpCouponCensus getBeanByCouponId(int couponId);
	/**
	 * 
	 * @param json
	 * @return
	 */
	int getCouponCount(SpiderStatusJson json);
	/**
	 * 修改本期没有扫到的优惠卷值
	 * @param obj
	 */
	void updateExpire(CpCouponCensus obj);
	/**
	 * 重新统计优惠卷
	 * @param obj
	 */
	void updateCouponIndex();

	
	  
	
}
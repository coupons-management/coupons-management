package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpCouponCensus;
import com.gopher.system.model.vo.response.CouponResultsOfScore;
import com.gopher.system.util.SpiderStatusJson;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CpCouponCensusDAO继承基类
 */
@Repository
public interface CpCouponCensusDAO extends MyBatisBaseDao<CpCouponCensus, Integer> {

	CpCouponCensus getBeanByCouponId(int couponId);

	CpCouponCensus getBean(CpCouponCensus cen);
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
	 * @param
	 */
	void updateCouponIndex();

	/**
	 * 通过爬虫筛选
	 * @param storeId
	 * @return
	 */
	List<CouponResultsOfScore>  getCouponResultsOfScore(int storeId);

	
	  
	
}
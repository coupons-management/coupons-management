package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpOutSiteCoupon;
import org.springframework.stereotype.Repository;

/**
 * CpOutSiteCouponDAO继承基类
 */
@Repository
public interface CpOutSiteCouponDAO extends MyBatisBaseDao<CpOutSiteCoupon, Integer> {
	void deleteByBean(CpOutSiteCoupon cpOutSiteCoupon);
}
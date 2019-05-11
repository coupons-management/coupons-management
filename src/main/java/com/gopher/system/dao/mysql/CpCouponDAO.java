package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpCoupon;
import org.springframework.stereotype.Repository;

/**
 * CpCouponDAO继承基类
 */
@Repository
public interface CpCouponDAO extends MyBatisBaseDao<CpCoupon, Integer> {
	CpCoupon getBeanByName(CpCoupon cou);
}
package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpCoupon;

/**
 * CpCouponDAO继承基类
 */
@Repository
public interface CpCouponDAO extends MyBatisBaseDao<CpCoupon, Integer> {
	CpCoupon getBeanByName(CpCoupon cou);
}
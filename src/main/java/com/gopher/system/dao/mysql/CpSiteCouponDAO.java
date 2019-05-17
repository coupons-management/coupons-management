package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpSiteCoupon;
import org.springframework.stereotype.Repository;

/**
 * CpSiteCouponDAO继承基类
 */
@Repository
public interface CpSiteCouponDAO extends MyBatisBaseDao<CpSiteCoupon, Integer> {
}
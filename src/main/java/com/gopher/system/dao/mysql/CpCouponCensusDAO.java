package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpCouponCensus;
import org.springframework.stereotype.Repository;

/**
 * CpCouponCensusDAO继承基类
 */
@Repository
public interface CpCouponCensusDAO extends MyBatisBaseDao<CpCouponCensus, Integer> {
}
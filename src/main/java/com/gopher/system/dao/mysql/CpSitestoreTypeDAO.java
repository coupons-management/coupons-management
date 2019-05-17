package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpSitestoreType;
import org.springframework.stereotype.Repository;

/**
 * CpSitestoreTypeDAO继承基类
 */
@Repository
public interface CpSitestoreTypeDAO extends MyBatisBaseDao<CpSitestoreType, Integer> {
}
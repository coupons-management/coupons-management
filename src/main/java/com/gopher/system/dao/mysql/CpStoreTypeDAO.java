package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpStoreType;
import org.springframework.stereotype.Repository;

/**
 * CpStoreTypeDAO继承基类
 */
@Repository
public interface CpStoreTypeDAO extends MyBatisBaseDao<CpStoreType, Integer> {
}
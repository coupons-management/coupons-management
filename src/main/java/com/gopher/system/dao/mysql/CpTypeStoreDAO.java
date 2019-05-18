package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpTypeStore;
import org.springframework.stereotype.Repository;

/**
 * CpTypeStoreDAO继承基类
 */
@Repository
public interface CpTypeStoreDAO extends MyBatisBaseDao<CpTypeStore, Integer> {
}
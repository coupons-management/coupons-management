package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpOutSiteStore;

/**
 * CpOutSiteStoreDAO继承基类
 */
@Repository
public interface CpOutSiteStoreDAO extends MyBatisBaseDao<CpOutSiteStore, Integer> {
}
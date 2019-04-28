package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpStore;
import org.springframework.stereotype.Repository;

/**
 * CpStoreDAO继承基类
 */
@Repository
public interface CpStoreDAO extends MyBatisBaseDao<CpStore, String> {
}
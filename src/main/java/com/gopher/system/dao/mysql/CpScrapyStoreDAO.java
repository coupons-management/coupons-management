package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpScrapyStore;
import org.springframework.stereotype.Repository;

/**
 * CpScrapyStoreDAO继承基类
 */
@Repository
public interface CpScrapyStoreDAO extends MyBatisBaseDao<CpScrapyStore, Integer> {
}